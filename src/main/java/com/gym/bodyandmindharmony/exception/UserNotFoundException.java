package com.gym.bodyandmindharmony.exception;

public class UserNotFoundException extends GymException {

    private static final int CODE = 4040;
    private static final String CATEGORY = "BAD_REQUEST";
    private static final String MESSAGE = "User with username %s does not exist";

    public UserNotFoundException(String username) {
        super(MESSAGE.formatted(username));
    }

    @Override
    public int getCode() {
        return CODE;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }
}
