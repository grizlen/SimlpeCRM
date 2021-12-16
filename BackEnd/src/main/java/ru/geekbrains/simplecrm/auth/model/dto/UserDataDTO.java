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
    private String surName;
    private String email;
    private String phone;
    private String address;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final UserDataDTO result;

        private Builder() {
            result = new UserDataDTO();
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
