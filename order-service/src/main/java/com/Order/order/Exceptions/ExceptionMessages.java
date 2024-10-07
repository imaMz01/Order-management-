package com.Order.order.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_OUT_OF_STOCK_("One of your products order is out of stock."),
    FAILED_TO_CREATE_PRODUCT("Failed to create Product. Something went wrong.");

    private final String message;


    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
