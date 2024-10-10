package com.Order.order.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    PRODUCT_OUT_OF_STOCK("One of your products order is out of stock."),
    ORDER_NOT_FOUND("Order with id %s doesn't exist."),
    PRODUCT_QUANTITY_VERIFICATION("quantity of product with ID %s equal to 0"),
    FAILED_TO_FIND_SERVICE("Oups something wrong, try later");

    private final String message;


    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
