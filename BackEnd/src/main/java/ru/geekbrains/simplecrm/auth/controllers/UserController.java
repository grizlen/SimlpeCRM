package ru.geekbrains.simplecrm.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.auth.model.dto.UserDetailsDTO;
import ru.geekbrains.simplecrm.auth.model.entity.UserDetails;
import ru.geekbrains.simplecrm.auth.services.UserService;

@RestController
@RequestMapping("/api/v1/auth/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public UserDetailsDTO getDetails(@PathVariable Long id) {
        return userService.getDetails(id);
    }
}
