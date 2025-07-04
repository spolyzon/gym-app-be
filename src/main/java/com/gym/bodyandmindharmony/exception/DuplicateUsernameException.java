package com.gym.bodyandmindharmony.exception;

public class DuplicateUsernameException extends GymException {

    private static final int CODE = 4000;
    private static final String CATEGORY = "BAD_REQUEST";
    private static final String MESSAGE = "Username already exists";

    public DuplicateUsernameException() {
        super(MESSAGE, CODE, CATEGORY);
    }

}
