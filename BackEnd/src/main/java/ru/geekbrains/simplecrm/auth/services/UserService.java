package ru.geekbrains.simplecrm.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.auth.model.dto.UserDataDTO;
import ru.geekbrains.simplecrm.auth.model.entity.User;
import ru.geekbrains.simplecrm.auth.model.entity.UserData;
import ru.geekbrains.simplecrm.auth.repositories.UserDataRepository;
import ru.geekbrains.simplecrm.auth.repositories.UserRepository;
import ru.geekbrains.simplecrm.common.exceptions.AutorizationException;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserDataRepository userDataRepository;
    private final UserRepository userRepository;

    public UserDataDTO getUserData(String login) {
        Optional<User> userOptional;
        if (login == null || (userOptional = userRepository.findByLogin(login)).isEmpty()) {
            throw new AutorizationException("user not found");
        }
        UserData userData =userDataRepository.findById(userOptional.get().getId())
                .orElse(null);
        if (userData == null) {
            userData = new UserData();
            userData.setId(userOptional.get().getId());
            userData = userDataRepository.save(userData);
        }
        return userDataToDTO(userData);
    }

    public void saveUserData(UserDataDTO request) {
        if (userRepository.findById(request.getId()).isEmpty()) {
            throw new AutorizationException("user not found.");
        }
        UserData userData = userDataDtoToUserData(request);
        userDataRepository.save(userData);
    }

    private UserData userDataDtoToUserData(UserDataDTO dto) {
        UserData userData = new UserData();
        userData.setId(dto.getId());
        userData.setFirstName(dto.getFirstName());
        userData.setLastName(dto.getLastName());
        userData.setSurName(dto.getSurName());
        userData.setEmail(dto.getEmail());
        userData.setPhone(dto.getPhone());
        userData.setAddress(dto.getAddress());
        return userData;
    }

    private UserDataDTO userDataToDTO(UserData userData) {
        return UserDataDTO.builder()
                .id(userData.getId())
                .firstName(userData.getFirstName())
                .lastName(userData.getLastName())
                .surName(userData.getSurName())
                .email(userData.getEmail())
                .phone(userData.getPhone())
                .address(userData.getAddress())
                .build();
    }
}
