package ru.geekbrains.simplecrm.auth.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.auth.model.dto.UserDataDTO;
import ru.geekbrains.simplecrm.auth.services.UserService;
import ru.geekbrains.simplecrm.common.model.UserInfo;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserDataDTO getUserData(Principal principal) {
        UserInfo userInfo = (UserInfo) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        String login = userInfo.getLogin();
        return userService.getUserData(login);
    }

    @PostMapping
    public void postUserData(@RequestBody UserDataDTO request) {
        if (request != null && request.getId() != null) {
            userService.saveUserData(request);
        }
    }
}
