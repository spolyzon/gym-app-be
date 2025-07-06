package com.gym.bodyandmindharmony.exception;

public class UserNotFoundException extends GymException {

    private static final ErrorEnum ERROR = ErrorEnum.USER_NOT_FOUND_ERROR;

    public UserNotFoundException(String username) {
        super(ERROR.getMessage().formatted(username));
    }

    @Override
    public int getCode() {
        return ERROR.getCode();
    }

    @Override
    public String getCategory() {
        return ERROR.getCategory();
    }
}
