package com.Order.order.Mapper;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Entities.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderLineMapper.class)
public interface OrderMapper {

    Order OrderDtoToOrder(OrderDto orderDto);
    OrderDto OrderToOrderDto(Order order);
    List<Order> OrderDtoToOrder(List<OrderDto> orderDto);
    List<OrderDto> OrderToOrderDto(List<Order> order);
}
