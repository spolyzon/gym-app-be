package com.gym.bodyandmindharmony.exception;

public class JwtExpiredException extends GymException {

    private static final ErrorEnum ERROR = ErrorEnum.EXPIRED_JWT_ERROR;

    public JwtExpiredException() {
        super(ERROR.getMessage());
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
