package com.gym.bodyandmindharmony.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorEnum {
    MISSING_AUTHORISATION_HEADER_ERROR(3000, "ACCESS_DENIED", "No Authorization header found"),
    EXPIRED_JWT_ERROR(3001, "BAD_REQUEST", "JWT is expired"),
    DUPLICATE_USERNAME_ERROR(4000, "BAD_REQUEST", "Username already exists"),
    USER_NOT_FOUND_ERROR(4040, "BAD_REQUEST", "User with username %s does not exist"),
    ;

    private final int code;
    private final String category;
    private final String message;
}
