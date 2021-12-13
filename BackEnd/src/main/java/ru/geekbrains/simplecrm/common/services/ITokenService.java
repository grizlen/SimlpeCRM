package ru.geekbrains.simplecrm.common.services;

import ru.geekbrains.simplecrm.common.model.UserInfo;

public interface ITokenService {
    String generateToken(UserInfo userInfo);
    UserInfo parseToken(String token);
}
