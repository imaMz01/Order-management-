package com.Order.User.Exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super(ExceptionMessages.USER_ALREADY_EXIST);
    }
}
