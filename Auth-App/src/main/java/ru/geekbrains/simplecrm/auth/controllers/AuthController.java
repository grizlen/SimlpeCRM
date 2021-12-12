package ru.geekbrains.simplecrm.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.simplecrm.auth.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public String alive() {
        return authService.alive();
    }

    @GetMapping("/signup")
    public String signUp() {
        return authService.signUp();
    }

    @GetMapping("/login")
    public String logIn() {
        return authService.logIn();
    }

    @GetMapping("/logout")
    public String logOut() {
        return authService.logOut();
    }
}
