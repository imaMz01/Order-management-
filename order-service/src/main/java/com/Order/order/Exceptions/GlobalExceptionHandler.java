package com.Order.order.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<String> handleProductOutOfStock(ProductOutOfStockException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INSUFFICIENT_STORAGE);
    }
//    @ExceptionHandler(ProductCreationException.class)
//    public ResponseEntity<String> handleUserCreationException(ProductCreationException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//    }
}
