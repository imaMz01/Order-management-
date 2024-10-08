package com.Order.order.Exceptions;

import com.Order.order.Exceptions.ExceptionMessages;
public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException() {
        super(ExceptionMessages.PRODUCT_OUT_OF_STOCK.getMessage());
    }
}
