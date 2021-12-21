package ru.geekbrains.simplecrm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.simplecrm.model.dto.ClientInfoDTO;
import ru.geekbrains.simplecrm.model.entity.User;
import ru.geekbrains.simplecrm.model.entity.ClientInfo;
import ru.geekbrains.simplecrm.repositories.ClientInfoRepository;
import ru.geekbrains.simplecrm.repositories.UserRepository;
import ru.geekbrains.simplecrm.exceptions.AutorizationException;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ClientService {

    private final ClientInfoRepository clientInfoRepository;
    private final UserRepository userRepository;

    public ClientInfoDTO getClientInfo(String login) {
        Optional<User> userOptional;
        if (login == null || (userOptional = userRepository.findByLogin(login)).isEmpty()) {
            throw new AutorizationException("user not found");
        }
        ClientInfo clientInfo = clientInfoRepository.findById(userOptional.get().getId())
                .orElse(null);
        if (clientInfo == null) {
            clientInfo = new ClientInfo();
            clientInfo.setId(userOptional.get().getId());
            clientInfo = clientInfoRepository.save(clientInfo);
        }
        return clientInfoToDTO(clientInfo);
    }

    public void saveClientInfo(ClientInfoDTO request) {
        if (userRepository.findById(request.getId()).isEmpty()) {
            throw new AutorizationException("user not found.");
        }
        ClientInfo clientInfo = clientInfoDtoToClientInfo(request);
        clientInfoRepository.save(clientInfo);
    }

    private ClientInfo clientInfoDtoToClientInfo(ClientInfoDTO dto) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setId(dto.getId());
        clientInfo.setFirstName(dto.getFirstName());
        clientInfo.setLastName(dto.getLastName());
        clientInfo.setSurName(dto.getSurName());
        clientInfo.setEmail(dto.getEmail());
        clientInfo.setPhone(dto.getPhone());
        clientInfo.setAddress(dto.getAddress());
        return clientInfo;
    }

    private ClientInfoDTO clientInfoToDTO(ClientInfo clientInfo) {
        return ClientInfoDTO.builder(clientInfo)
                .build();
    }
}
