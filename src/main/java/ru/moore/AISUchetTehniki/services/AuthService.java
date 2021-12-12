package ru.moore.AISUchetTehniki.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.moore.AISUchetTehniki.exeptions.ErrorTemplate;
import ru.moore.AISUchetTehniki.models.Entity.Account;
import ru.moore.AISUchetTehniki.repositories.AccountRepository;
import ru.moore.AISUchetTehniki.security.JwtProvider;
import ru.moore.AISUchetTehniki.security.dto.JwtResponse;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;
import ru.moore.AISUchetTehniki.utils.MailSender;

import java.sql.SQLException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final Map<String, String> refreshStorage = new HashMap<>();

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final MapperUtils mapperUtils;
    private final MailSender mailSender;

    public ResponseEntity<?> registerUser(Account signUp) {
        signUp.setPassword(passwordEncoder.encode(signUp.getPassword()));
        signUp.setConfirmation(false);
        signUp.setConfirmationCode(UUID.randomUUID().toString());
        signUp.setGlobalId(UUID.randomUUID().toString());

        try {
            accountRepository.save(mapperUtils.map(signUp, Account.class));
        } catch (DataIntegrityViolationException ex) {
            if (((SQLException) ex.getMostSpecificCause()).getSQLState().equals("23505")) {
                throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Почтовый ящик уже используется!");
            }
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, ex.getRootCause().getMessage());
        }

        String message = String.format(
                "Здравствуйте, %s! \n" +
                        "Добро пожаловать на площадьку для трейдеров. Пожалуйста, активируйте вашу учетную запись перейдя по ссылке: http://localhost:8080/api/v1/auth/activate/%s",
                signUp.getFirstName(),
                signUp.getConfirmationCode()
        );
//        mailSender.send(signUp.getEmail(), "Активация учетной записи", message);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    public ResponseEntity<?> loginUser(String login, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        } catch (BadCredentialsException ex) {
            throw new ErrorTemplate(HttpStatus.NOT_FOUND, "Неверный логин или пароль!");
        }

        Account account = accountRepository.findByEmail(login).get();

        if (!account.isConfirmation()) {
            throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Учетная запись не активирована!");
        }

        final String accessToken = jwtProvider.generateAccessToken(account);
        final String refreshToken = jwtProvider.generateRefreshToken(account);
        refreshStorage.put(account.getEmail(), refreshToken);

        return new ResponseEntity<>(new JwtResponse(accessToken, refreshToken), HttpStatus.OK);
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            ObjectMapper mapper = new ObjectMapper();
            Account account = mapper.convertValue(claims.get("user"), Account.class);
            final String saveRefreshToken = refreshStorage.get(account.getEmail());
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final String accessToken = jwtProvider.generateAccessToken(account);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            ObjectMapper mapper = new ObjectMapper();
            Account account = mapper.convertValue(claims.get("user"), Account.class);
            final String saveRefreshToken = refreshStorage.get(account.getEmail());
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final String accessToken = jwtProvider.generateAccessToken(account);
                final String newRefreshToken = jwtProvider.generateRefreshToken(account);
                refreshStorage.put(account.getEmail(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new ErrorTemplate(HttpStatus.BAD_REQUEST, "Невалидный JWT токен");
    }

//    public JwtAuthentication getAuthInfo() {
//        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
//    }
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), authorities);
//    }
//
//    private Optional<Account> findByUsername(String username) {
//        return accountRepository.findByEmail(username);
//    }

    public boolean activateUser(String code) {
        Account account = accountRepository.findByConfirmationCode(code);

        if (account == null) {
            return false;
        }

        account.setConfirmationCode(null);
        account.setConfirmation(true);

        accountRepository.save(account);

        return true;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", login)));
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), authorities);
    }
}
