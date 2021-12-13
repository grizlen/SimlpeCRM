package ru.geekbrains.simplecrm.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.auth.model.dto.UserDetailsDTO;
import ru.geekbrains.simplecrm.auth.model.entity.UserDetails;
import ru.geekbrains.simplecrm.auth.repositories.UserDetailsRepository;
import ru.geekbrains.simplecrm.auth.repositories.UserRepository;
import ru.geekbrains.simplecrm.common.exceptions.AutorizationException;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;

    public UserDetailsDTO getDetails(Long id) {
        if (id == null || userRepository.findById(id).isEmpty()) {
            throw new AutorizationException("user not found");
        }
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        UserDetails details =userDetails.orElse(null);
        if (userDetails.isEmpty()) {
            details = new UserDetails();
            details.setId(id);
            details = userDetailsRepository.save(details);
        }
        return userDetailsToDTO(details);
    }

    private UserDetailsDTO userDetailsToDTO(UserDetails details) {
        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setId(details.getId());
        dto.setFirstName(details.getFirstName());
        dto.setLastName(details.getLastName());
        dto.setSureName(details.getSureName());
        dto.setPhone(details.getPhone());
        dto.setAddress(details.getAddress());
        return dto;
    }
}
