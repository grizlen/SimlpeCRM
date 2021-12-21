package ru.geekbrains.simplecrm.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simplecrm.model.dto.ClientInfoDTO;
import ru.geekbrains.simplecrm.services.ClientService;
import ru.geekbrains.simplecrm.security.UserInfo;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class ClientsController {

    private final ClientService clientService;

    @GetMapping
    public ClientInfoDTO getUserData(Principal principal) {
        UserInfo userInfo = (UserInfo) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        String login = userInfo.getLogin();
        return clientService.getClientInfo(login);
    }

    @PostMapping
    public void postUserData(@RequestBody ClientInfoDTO request) {
        if (request != null && request.getId() != null) {
            clientService.saveClientInfo(request);
        }
    }
}
