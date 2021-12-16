package ru.geekbrains.simplecrm.auth.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@NoArgsConstructor
public class UserData {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sur_name")
    private String surName;
    private String email;
    private String phone;
    private String address;
}
