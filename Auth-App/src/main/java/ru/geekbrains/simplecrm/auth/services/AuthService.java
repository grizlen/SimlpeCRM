package ru.geekbrains.simplecrm.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.auth.model.dto.AuthRequestDTO;
import ru.geekbrains.simplecrm.auth.model.dto.AuthResponseDTO;
import ru.geekbrains.simplecrm.auth.model.entity.Role;
import ru.geekbrains.simplecrm.auth.model.entity.User;
import ru.geekbrains.simplecrm.auth.repositories.RoleRepository;
import ru.geekbrains.simplecrm.auth.repositories.UserRepository;
import ru.geekbrains.simplecrm.common.Services.ITokenService;
import ru.geekbrains.simplecrm.common.exceptions.AutorizationException;
import ru.geekbrains.simplecrm.common.model.UserInfo;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ITokenService tokenService;

    public String alive() {
        return "alive";
    }

    public AuthResponseDTO signUp(AuthRequestDTO request) {
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(
                () -> new RuntimeException("Role USER not found")
        );
        user.setRoles(Collections.singletonList(role));
        UserInfo userInfo = userToUserInfo(userRepository.save(user));
        return new AuthResponseDTO(userInfo.getLogin(), tokenService.generateToken(userInfo));
    }

    public AuthResponseDTO logIn(AuthRequestDTO request) {
        User user = userRepository.findByLogin(request.getLogin()).orElseThrow(
                () -> new AutorizationException("User: " + request.getLogin() + " not found.")
        );
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AutorizationException("invalid password");
        }
        return new AuthResponseDTO(user.getLogin(), tokenService.generateToken(userToUserInfo(user)));
    }

    public void logOut(String token) {
        // TODO: 13.12.2021 Redis support
//        redisRepository.setKey(token);
    }

    private UserInfo userToUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setLogin(user.getLogin());
        userInfo.setRoles(user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList()));
        return userInfo;
    }
}
