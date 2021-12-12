package ru.geekbrains.simplecrm.common.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionInfoDTO {
    private final int status;
    private final String message;
    private final Date timeStamp;

    public ExceptionInfoDTO(int status, String message) {
        this.status = status;
        this.message = message;
        timeStamp = new Date();
    }
}
