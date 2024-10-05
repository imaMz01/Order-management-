package com.Order.product.Exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String userId) {
        super(ExceptionMessages.PRODUCT_NOT_FOUND.getMessage(userId));
    }
}
