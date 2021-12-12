package ru.geekbrains.simplecrm.auth.services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String alive() {
        return "alive";
    }

    public String signUp() {
        return "signUp";
    }

    public String logIn() {
        return "logIn";
    }

    public String logOut() {
        return "logOut";
    }
}
