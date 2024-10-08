package com.Order.order.Exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String id) {
        super(ExceptionMessages.ORDER_NOT_FOUND.getMessage(id));
    }
}
