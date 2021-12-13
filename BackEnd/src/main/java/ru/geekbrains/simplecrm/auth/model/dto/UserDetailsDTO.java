package ru.geekbrains.simplecrm.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String sureName;
    private String phone;
    private String address;
}
