package com.Order.User.Exceptions;

public class UserCreationException extends RuntimeException{
        public UserCreationException() {
            super(ExceptionMessages.FAILED_TO_CREATE_USER.getMessage());
        }
}
