package com.Order.order.Services;

import com.Order.order.Dtos.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto add(OrderDto orderDto);
    OrderDto update(OrderDto orderDto);
    OrderDto orderById(String id);
    List<OrderDto> all();
    String delete(String id);
}
