package ru.geekbrains.simplecrm.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.simplecrm.model.entity.ClientInfo;

@Getter
@Setter
@NoArgsConstructor
public class ClientInfoDTO {
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

    public static Builder builder(ClientInfo user) {
        return new Builder(user);
    }

    public static class Builder {
        private final ClientInfoDTO result;

        private Builder(Long id) {
            result = new ClientInfoDTO();
            result.id = id;
        }

        public Builder(ClientInfo clientInfo) {
            result = new ClientInfoDTO();
            result.id = clientInfo.getId();
            result.firstName = clientInfo.getFirstName();
            result.lastName = clientInfo.getLastName();
            result.surName = clientInfo.getSurName();
            result.email = clientInfo.getEmail();
            result.phone = clientInfo.getPhone();
            result.address = clientInfo.getAddress();
        }

        public ClientInfoDTO build() {
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
