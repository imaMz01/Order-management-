package com.Order.order.Controller;

import com.Order.order.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order")
public class OrderController {

    private final OrderService orderService;

}
