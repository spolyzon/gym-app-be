package com.gym.bodyandmindharmony.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GymException extends RuntimeException {

    private final int code;
    private final String category;

    public GymException(String message, int code, String category) {
        super(message);
        this.code = code;
        this.category = category;
    }
}
