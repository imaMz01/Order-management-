package com.Order.order.Controller;

import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Dtos.UserDto;
import com.Order.order.FeignClient.UserFeign;
import com.Order.order.Services.OrderService;
import com.Order.order.Services.OrderServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order")
public class OrderController {

    private final OrderService orderService;
    private final OrderServiceImp orderServiceImp;
    private final UserFeign userFeign;

    @PostMapping
    public boolean check(@RequestBody List<OrderLineDto> orderLineDtoList){
        return  orderServiceImp.test(orderLineDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> userById(@PathVariable String id){
        return userFeign.userById(id);
    }
}
