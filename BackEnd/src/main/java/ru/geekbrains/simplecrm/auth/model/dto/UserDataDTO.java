package ru.geekbrains.simplecrm.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.simplecrm.auth.model.entity.User;
import ru.geekbrains.simplecrm.auth.model.entity.UserData;

@Getter
@Setter
@NoArgsConstructor
public class UserDataDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String surName;
    private String email;
    private String phone;
    private String address;

    public static Builder builder(Long id) {
        return new Builder(id);
    }

    public static Builder builder(UserData user) {
        return new Builder(user);
    }

    public static class Builder {
        private final UserDataDTO result;

        private Builder(Long id) {
            result = new UserDataDTO();
            result.id = id;
        }

        public Builder(UserData userData) {
            result = new UserDataDTO();
            result.id = userData.getId();
            result.firstName = userData.getFirstName();
            result.lastName = userData.getLastName();
            result.surName = userData.getSurName();
            result.email = userData.getEmail();
            result.phone = userData.getPhone();
            result.address = userData.getAddress();
        }

        public UserDataDTO build() {
            return result;
        }

        public Builder id(Long id) {
            result.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            result.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            result.lastName = lastName;
            return this;
        }

        public Builder surName(String surName) {
            result.surName = surName;
            return this;
        }

        public Builder email(String email) {
            result.email = email;
            return this;
        }

        public Builder phone(String phone) {
            result.phone = phone;
            return this;
        }

        public Builder address(String address) {
            result.address = address;
            return this;
        }
    }
}
