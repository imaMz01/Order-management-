package com.Order.order.Services;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Dtos.UserDto;
import com.Order.order.FeignClient.ProductFeign;
import com.Order.order.FeignClient.UserFeign;
import com.Order.order.Mapper.OrderMapper;
import com.Order.order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductFeign productFeign;
    private final UserFeign userFeign;

    public boolean test(List<OrderLineDto> orderDtoList){
        return productFeign.checkQuantity(orderDtoList);
    }

    @Override
    public OrderDto add(OrderDto orderDto) {
//        Order order = orderMapper.OrderDtoToOrder(orderDto);
//        order.setIdUser(orderDto.getUserDto().getId());
//        order.getOrdersLine().stream()
//                .forEach(
//                product -> pro
//        );
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
