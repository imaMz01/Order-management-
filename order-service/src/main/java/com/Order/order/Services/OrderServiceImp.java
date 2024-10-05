package com.Order.order.Services;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;


    @Override
    public OrderDto add(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto orderById(String id) {
        return null;
    }

    @Override
    public List<OrderDto> all() {
        return List.of();
    }

    @Override
    public String delete(String id) {
        return "";
    }
}
