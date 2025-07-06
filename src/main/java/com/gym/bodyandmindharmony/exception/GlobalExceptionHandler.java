package com.gym.bodyandmindharmony.exception;

import com.gym.bodyandmindharmony.models.GymExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleMalformedRequestException(
            HttpMessageNotReadableException ex
    ) {
        log.error(ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(GymExceptionModel.builder()
                        .code(4001)
                        .category("BAD_REQUEST")
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleDuplicateUsernameException(DuplicateUsernameException ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(GymExceptionModel.builder()
                        .code(ex.getCode())
                        .category(ex.getCategory())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleUserNotFoundException(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .status(NOT_FOUND)
                .body(GymExceptionModel.builder()
                        .code(ex.getCode())
                        .category(ex.getCategory())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<GymExceptionModel> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(GymExceptionModel.builder()
                        .code(500)
                        .category("SERVER_ERROR")
                        .message(ex.getMessage())
                        .build()
                );
    }
}
