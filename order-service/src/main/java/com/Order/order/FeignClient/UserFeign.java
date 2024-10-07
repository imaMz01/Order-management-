package com.Order.order.FeignClient;

import com.Order.order.Dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserFeign {

    @GetMapping("User/userById/{id}")
    public ResponseEntity<UserDto> userById(@PathVariable String id);
}
