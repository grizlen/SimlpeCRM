package ru.geekbrains.simplecrm.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleAutorizationException(AutorizationException e) {
        return new ResponseEntity<>(
                new ExceptionInfoDTO(HttpStatus.UNAUTHORIZED.value(), 
                        e.getClass().getName() + ": " + e.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler
    public ResponseEntity<?> handleOtherException(Exception e) {
        return new ResponseEntity<>(
                new ExceptionInfoDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getClass().getName() + ": " + e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
