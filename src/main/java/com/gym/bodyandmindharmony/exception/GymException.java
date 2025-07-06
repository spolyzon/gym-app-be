package com.gym.bodyandmindharmony.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GymException extends RuntimeException {

    private ErrorEnum errorEnum;

    public GymException(String message) {
        super(message);
    }

    public GymException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
    }

    public int getCode() {
        return errorEnum.getCode();
    }

    public String getCategory() {
        return errorEnum.getCategory();
    }
}
