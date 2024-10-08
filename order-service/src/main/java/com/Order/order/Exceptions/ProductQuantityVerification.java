package com.Order.order.Exceptions;

public class ProductQuantityVerification extends  RuntimeException{
    public ProductQuantityVerification(String id) {
        super(ExceptionMessages.PRODUCT_QUANTITY_VERIFICATION.getMessage(id));
    }
}
