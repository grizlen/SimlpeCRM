package ru.geekbrains.simplecrm.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDataDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String sureName;
    private String email;
    private String phone;
    private String address;
}
