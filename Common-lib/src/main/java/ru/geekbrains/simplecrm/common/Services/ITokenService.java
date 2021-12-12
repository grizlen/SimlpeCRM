package ru.geekbrains.simplecrm.common.Services;

import ru.geekbrains.simplecrm.common.model.UserInfo;

public interface ITokenService {
    String generateToken(UserInfo userInfo);
    UserInfo parseToken(String token);
}
