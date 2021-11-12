package ru.moore.AISUchetTehniki.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.moore.AISUchetTehniki.models.Entity.Account;
import ru.moore.AISUchetTehniki.security.SignInDto;
import ru.moore.AISUchetTehniki.services.AuthService;

import javax.validation.Valid;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Account signUp) {
        return userService.registerUser(signUp);
    }

    @GetMapping("/activate/{code}")
    public RedirectView activate(@PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            //model.addAttribute("message", "User successfully activated");
        } else {
            //model.addAttribute("message", "Activation code is not found!");
        }

        return new RedirectView("http://localhost:3000/login");
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> loginUser(@RequestBody SignInDto signIn) {
        return userService.loginUser(signIn.getEmail(), signIn.getPassword());
    }

}
