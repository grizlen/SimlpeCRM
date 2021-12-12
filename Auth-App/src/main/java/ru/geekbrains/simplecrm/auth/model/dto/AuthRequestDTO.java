package ru.geekbrains.simplecrm.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequestDTO {
    private Long id;
    private String login;
    private String password;
}
