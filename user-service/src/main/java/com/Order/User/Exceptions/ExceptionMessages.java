package com.Order.User.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    USER_NOT_FOUND("User with id %s not found."),
    USER_ALREADY_EXIST("A user already exists with the email %s ."),
    FAILED_TO_CREATE_USER("Failed to create user. Something went wrong.");

    private final String message;


    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
