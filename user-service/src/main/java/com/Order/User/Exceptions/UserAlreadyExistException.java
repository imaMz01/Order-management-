package com.Order.User.Exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String email) {
        super(ExceptionMessages.USER_ALREADY_EXIST.getMessage(email));
    }
}
