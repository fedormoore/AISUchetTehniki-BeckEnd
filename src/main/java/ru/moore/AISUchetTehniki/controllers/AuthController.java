package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.moore.AISUchetTehniki.models.Entity.Account;
import ru.moore.AISUchetTehniki.security.dto.JwtRequest;
import ru.moore.AISUchetTehniki.security.dto.JwtResponse;
import ru.moore.AISUchetTehniki.security.dto.RefreshJwtRequest;
import ru.moore.AISUchetTehniki.services.AuthService;

import javax.validation.Valid;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody Account signUp) {
        return authService.registerUser(signUp);
    }

    @GetMapping("/activate/{code}")
    public RedirectView activate(@PathVariable String code) {
        boolean isActivated = authService.activateUser(code);

        if (isActivated) {
            //model.addAttribute("message", "User successfully activated");
        } else {
            //model.addAttribute("message", "Activation code is not found!");
        }

        return new RedirectView("http://localhost:3000/login");
    }

    @PostMapping("/refresh-tokens")
    public ResponseEntity<?> refreshTokens(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody JwtRequest signIn) {
        return authService.loginUser(signIn.getLogin(), signIn.getPassword());
    }

}
