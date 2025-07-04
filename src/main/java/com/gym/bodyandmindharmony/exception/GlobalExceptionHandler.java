package com.gym.bodyandmindharmony.exception;

import com.gym.bodyandmindharmony.models.GymExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleDuplicateUsernameException(DuplicateUsernameException ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .ok()
                .body(GymExceptionModel.builder()
                        .code(ex.getCode())
                        .category("SERVER_ERROR")
                        .message(ex.getMessage())
                        .build()
                );
    }

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .ok()
                .body(GymExceptionModel.builder()
                        .code(500)
                        .category("SERVER_ERROR")
                        .message(ex.getMessage())
                        .build()
                );
    }
}
