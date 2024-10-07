package com.Order.order.FeignClient;


import com.Order.order.Dtos.OrderLineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductFeign {

    @PostMapping
    boolean checkQuantity(@RequestBody List<OrderLineDto> orderLineDtoList);
}
