package com.Order.product.Exceptions;

public class ProductCreationException extends RuntimeException{
        public ProductCreationException() {
            super(ExceptionMessages.FAILED_TO_CREATE_PRODUCT.getMessage());
        }
}
