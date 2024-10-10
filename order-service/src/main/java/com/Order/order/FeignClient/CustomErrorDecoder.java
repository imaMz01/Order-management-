package com.Order.order.FeignClient;

import com.Order.order.Exceptions.FailedToFindService;
import feign.codec.ErrorDecoder;
import feign.Response;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 ->
                // Handle 400 Bad Request
                    new RuntimeException("Bad Request");
            case 404 ->
                // Handle 404 Not Found
                    new FailedToFindService();
            case 500 ->
                // Handle 500 Internal Server Error
                    new RuntimeException("Internal Server Error");
            default -> new Exception("Generic error");
        };
    }
}
