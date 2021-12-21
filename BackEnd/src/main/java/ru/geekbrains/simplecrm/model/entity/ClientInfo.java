package ru.geekbrains.simplecrm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clients_info")
@Getter
@Setter
@NoArgsConstructor
public class ClientInfo {
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
