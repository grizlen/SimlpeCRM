package ru.geekbrains.simplecrm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.repositories.UserRepository;
import ru.geekbrains.simplecrm.exceptions.AutorizationException;
import ru.geekbrains.simplecrm.model.dto.AuthResponseDTO;
import ru.geekbrains.simplecrm.model.entity.Role;
import ru.geekbrains.simplecrm.model.entity.User;
import ru.geekbrains.simplecrm.repositories.RoleRepository;
import ru.geekbrains.simplecrm.security.JwtService;
import ru.geekbrains.simplecrm.security.UserInfo;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO signUp(String login, String password, String authority) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        Role role = roleRepository.findByName(authority).orElseThrow(
                () -> new AutorizationException("Role: " + authority + " not found.")
        );
        user.setRoles(Collections.singletonList(role));
        UserInfo userInfo = userToUserInfo(userRepository.save(user));
        return new AuthResponseDTO(login, jwtService.generateToken(userInfo));
    }

    public AuthResponseDTO logIn(String login, String password) {
        User user = userRepository.findByLogin(login).orElseThrow(
                () -> new AutorizationException("User: " + login + " not found.")
        );
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AutorizationException("invalid password");
        }
        return new AuthResponseDTO(login, jwtService.generateToken(userToUserInfo(user)));
    }

    public void logOut(String token) {
    }

    private UserInfo userToUserInfo(User user) {
        return new UserInfo(
                user.getId(),
                user.getLogin(),
                user.getRoles().stream()
                        .map(role -> role.getName())
                        .collect(Collectors.joining(","))
                );
    }
}
