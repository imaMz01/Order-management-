package com.Order.order.FeignClient;

import com.Order.order.Dtos.UserDto;
import com.Order.order.Exceptions.FailedToFindService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.control.MappingControl;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Slf4j
@Component
public class UserFallBack implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable cause) {
        return new UserFeign() {
            @Override
            public ResponseEntity<UserDto> userById(String id) {
                throw new FailedToFindService();
            }
        };
    }
}
