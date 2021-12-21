package ru.geekbrains.simplecrm.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String login;
    private String authorities;
}
