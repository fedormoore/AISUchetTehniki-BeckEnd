package ru.moore.AISUchetTehniki.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Entity.Account;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secretAccess}")
    private String jwtAccessSecret;

    @Value("${jwt.secretRefresh}")
    private String jwtRefreshSecret;

    public String generateAccessToken(Account account) {

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(account.getId())
                .globalId(account.getGlobalId())
                .email(account.getEmail())
                .build();

        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusSeconds(5).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);

        final String accessToken = Jwts.builder()
                .claim("user", userPrincipal)
//                .setSubject(userPrincipal.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(accessExpiration)
                .signWith(SignatureAlgorithm.HS256, jwtAccessSecret)
                .compact();
        return accessToken;
    }

    public String generateRefreshToken(Account account) {

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(account.getId())
                .globalId(account.getGlobalId())
                .email(account.getEmail())
                .build();

        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(1).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        final String refreshToken = Jwts.builder()
                .claim("user", userPrincipal)
                .setExpiration(refreshExpiration)
                .signWith(SignatureAlgorithm.HS512, jwtRefreshSecret)
                .compact();
        return refreshToken;
    }

    public boolean validateAccessToken(@NonNull String token) {
        return validateToken(token, jwtAccessSecret);
    }

    public boolean validateRefreshToken(@NonNull String token) {
        return validateToken(token, jwtRefreshSecret);
    }

    private boolean validateToken(@NonNull String token, @NonNull String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
//            logger.error("Token expired", expEx);
            throw new ErrorTemplate(HttpStatus.UNAUTHORIZED, "Срок действия токена JWT истек");
        } catch (UnsupportedJwtException unsEx) {
            logger.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
            logger.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
            logger.error("Invalid signature", sEx);
        } catch (Exception e) {
            logger.error("invalid token", e);
        }
        return false;
    }

    public Claims getAccessClaims(@NonNull String token) {
        return getUserPrincipalFromToken(token, jwtAccessSecret);
    }

    public Claims getRefreshClaims(@NonNull String token) {
        return getUserPrincipalFromToken(token, jwtRefreshSecret);
    }

    public Claims getUserPrincipalFromToken(@NonNull String token, @NonNull String secret) {
//        Jws<Claims> jwsClaims = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token);
//        ObjectMapper mapper = new ObjectMapper();
//        UserPrincipal userPrincipal = mapper.convertValue(jwsClaims.getBody().get("user"), UserPrincipal.class);
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
