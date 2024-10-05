package com.Order.User.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super(ExceptionMessages.USER_NOT_FOUND.getMessage(userId));
    }
}
