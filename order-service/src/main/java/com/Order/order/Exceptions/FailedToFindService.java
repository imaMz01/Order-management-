package com.Order.order.Exceptions;

public class FailedToFindService extends RuntimeException {
    public FailedToFindService(String id) {
        super(ExceptionMessages.FAILED_TO_FIND_SERVICE.getMessage(id));
    }
}
