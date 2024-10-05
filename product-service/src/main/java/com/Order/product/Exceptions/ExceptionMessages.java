package com.Order.product.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_NOT_FOUND("Product with id %s not found."),
    FAILED_TO_CREATE_PRODUCT("Failed to create Product. Something went wrong.");

    private final String message;


    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
