package ru.geekbrains.simplecrm.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.auth.model.dto.AuthRequestDTO;
import ru.geekbrains.simplecrm.auth.model.dto.AuthResponseDTO;
import ru.geekbrains.simplecrm.auth.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthResponseDTO signUp(@RequestBody AuthRequestDTO request) {
        String login = request.getLogin();
        String password = request.getPassword();
        log.info("signUp({}, {})", login, password);
        return authService.signUp(login, password, "ROLE_USER");
    }

    @PostMapping("/login")
    public AuthResponseDTO logIn(@RequestBody AuthRequestDTO request) {
        String login = request.getLogin();
        String password = request.getPassword();
        log.info("logIn({}, {})", login, password);
        return authService.logIn(login, password);
    }

    @GetMapping("/logout")
    public void logOut(@RequestHeader("Authorization") String token) {
        log.info("logOut({})", token);
        if (token != null) {
            authService.logOut(token);
        }
    }
}
