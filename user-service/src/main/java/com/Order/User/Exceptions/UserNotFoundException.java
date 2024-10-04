package com.Order.User.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ExceptionMessages.USER_NOT_FOUND);
    }
}
