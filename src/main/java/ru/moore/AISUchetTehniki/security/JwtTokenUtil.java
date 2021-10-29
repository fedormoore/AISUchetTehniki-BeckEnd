package ru.moore.AISUchetTehniki.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;

@Component
public class JwtTokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User userDetails) {

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(userDetails.getId())
                .organization_id(userDetails.getOrganization().getId())
                .build();

        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + 60 * 60 * 1000); // todo
        return Jwts.builder()
                .claim("user", userPrincipal)
//                .setSubject(userPrincipal.getEmail())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, new Function<Claims, String>() {
            @Override
            public String apply(Claims claims) {
                return claims.getSubject();
            }
        });
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    public UserPrincipal getUserFromToken(String token) {
        Jws<Claims> jwsClaims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        ObjectMapper mapper = new ObjectMapper();
        UserPrincipal userPrincipal = mapper.convertValue(jwsClaims.getBody().get("user"), UserPrincipal.class);
        return userPrincipal;
    }

//    public void validateToken(String authToken) throws RecordExistsException {
//        try {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
//        } catch (SignatureException ex) {
//            logger.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            logger.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            throw new RecordExistsException("Ошибка", "Срок действия токена JWT истек");
//        } catch (UnsupportedJwtException ex) {
//            logger.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            logger.error("JWT claims string is empty.");
//        }
//    }
}
