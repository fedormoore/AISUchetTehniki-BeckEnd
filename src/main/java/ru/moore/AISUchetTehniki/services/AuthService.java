package ru.moore.AISUchetTehniki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ru.moore.AISUchetTehniki.exeptions.TemplateMessage;
import ru.moore.AISUchetTehniki.security.SignUpDto;
import ru.moore.AISUchetTehniki.models.Entity.spr.User;
import ru.moore.AISUchetTehniki.repositories.OrganizationRepository;
import ru.moore.AISUchetTehniki.repositories.spr.UserRepository;
import ru.moore.AISUchetTehniki.security.JwtResponse;
import ru.moore.AISUchetTehniki.security.JwtTokenUtil;
import ru.moore.AISUchetTehniki.services.mappers.MapperUtils;
import ru.moore.AISUchetTehniki.utils.MailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final OrganizationRepository organizationRepository;

    private final MapperUtils mapperUtils;

    private final MailSender mailSender;

    public ResponseEntity<?> registerUser(SignUpDto signUp) {
        if (organizationRepository.existsByName(signUp.getOrganization().getName())) {
            return new ResponseEntity<>(new TemplateMessage(HttpStatus.UNAUTHORIZED.value(), "Ошбика","Организация уже используется!"), HttpStatus.UNAUTHORIZED);
        }
        if (userRepository.existsByEmail(signUp.getEmail())) {
            return new ResponseEntity<>(new TemplateMessage(HttpStatus.UNAUTHORIZED.value(), "Ошбика","Почтовый ящик уже используется!"), HttpStatus.UNAUTHORIZED);
        }

        organizationRepository.save(signUp.getOrganization());

        signUp.setPassword(passwordEncoder.encode(signUp.getPassword()));
        signUp.setConfirmation(false);
        signUp.setConfirmationCode(UUID.randomUUID().toString());
        userRepository.save(mapperUtils.map(signUp, User.class));

        String message = String.format(
                "Здравствуйте, %s! \n" +
                        "Добро пожаловать на площадьку для трейдеров. Пожалуйста, активируйте вашу учетную запись перейдя по ссылке: http://localhost:8080/api/v1/auth/activate/%s",
                signUp.getFirstName(),
                signUp.getConfirmationCode()
        );
        mailSender.send(signUp.getEmail(), "Активация учетной записи", message);

        return new ResponseEntity<>(new TemplateMessage(HttpStatus.OK.value(), "Информационное сообщение","Пользователь успешно зарегистрирован!\nПерейти по ссылке, высланной в письме для ативации учетной записи."), HttpStatus.OK);
    }

    public ResponseEntity<?> loginUser(String login, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(new TemplateMessage(HttpStatus.UNAUTHORIZED.value(), "Ошбика","Неверный логин или пароль!"), HttpStatus.UNAUTHORIZED);
        }

        User user = userRepository.findByEmail(login).get();

        if (!user.isConfirmation()) {
            return new ResponseEntity<>(new TemplateMessage(HttpStatus.UNAUTHORIZED.value(), "Ошбика","Учетная запись не активирована!"), HttpStatus.UNAUTHORIZED);
            //throw new RecordExistsException("Ошибка", "Учетная запись не активирована!");
        }

        String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    private Optional<User> findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByConfirmationCode(code);

        if (user == null) {
            return false;
        }

        user.setConfirmationCode(null);
        user.setConfirmation(true);

        userRepository.save(user);

        return true;
    }

//    public UserDto getUser(Authentication authentication) {
//        return mapperUtils.map(userRepository.findById(((UserPrincipal)authentication.getPrincipal()).getId()).get(), UserDto.class);
//    }
//
//    public UserDto saveUser(Authentication authentication, User user) {
//        User user1 = userRepository.findByEmail(((UserPrincipal)authentication.getPrincipal()).getEmail()).get();
//        return mapperUtils.map(userRepository.save(user1), UserDto.class);
//    }
}
