package com.gym.bodyandmindharmony.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class GymException extends RuntimeException {

    public GymException(String message) {
        super(message);
    }

    public abstract int getCode();

    public abstract String getCategory();
}
