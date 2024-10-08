package com.Order.order.Services;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Dtos.UserDto;
import com.Order.order.Entities.Order;
import com.Order.order.Exceptions.OrderNotFound;
import com.Order.order.Exceptions.ProductOutOfStockException;
import com.Order.order.Exceptions.ProductQuantityVerification;
import com.Order.order.FeignClient.ProductFeign;
import com.Order.order.FeignClient.UserFeign;
import com.Order.order.Mapper.OrderLineMapper;
import com.Order.order.Mapper.OrderMapper;
import com.Order.order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductFeign productFeign;
    private final UserFeign userFeign;

    @Override
    @Transactional
    public OrderDto add(OrderDto orderDto) {
        orderDto.getOrdersLine()
                .forEach(
                        orderLineDto ->  {
                            if(orderLineDto.getQuantity()<=0){
                        throw new ProductQuantityVerification(orderLineDto.getIdProduct());
                            }
                 }
                );
        if( !productFeign.checkQuantity(orderDto.getOrdersLine())){
            throw new ProductOutOfStockException();
        }
        Order order = orderMapper.OrderDtoToOrder(orderDto);
        System.out.println(order.toString());
        order.getOrdersLine().forEach(e-> System.out.println(e.toString()));
        order.setIdUser(orderDto.getUserDto().getId());
        order.setDeleted(false);
        order.setIdOrder(UUID.randomUUID().toString());
        order.getOrdersLine().forEach(el -> {
            el.setOrder(order);
            el.setIdOrderLine(UUID.randomUUID().toString());
        });
        productFeign.decreaseStock(orderDto.getOrdersLine());
        return orderMapper.OrderToOrderDto(
                orderRepository.save(order)
        );
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        Order order = helper(orderDto.getIdOrder());
        order.setOrdersLine(OrderLineMapper.mapper.OrderLineDtoToOrderLine(
                orderDto.getOrdersLine())
        );
        order.getOrdersLine().forEach(el -> {
            el.setOrder(order);
        });
        return orderMapper.OrderToOrderDto(orderRepository.save(order));
    }

    public Order helper(String id){
        return orderRepository.findById(id).filter(
                order -> !order.isDeleted()
        ).orElseThrow(
                () -> new OrderNotFound(id)
        );
    }
    @Override
    public OrderDto orderById(String id) {
        return getOrderDto(id);
    }

    private OrderDto getOrderDto(String id) {
        OrderDto orderDto = orderMapper.OrderToOrderDto(helper(id));
        orderDto.setUserDto(userFeign.userById(helper(id).getIdUser()).getBody());
        return orderDto;
    }

    @Override
    public List<OrderDto> all() {
        return orderRepository.findAll().stream()
                .filter(order -> !order.isDeleted())
                .map(
                        order -> {
                            return getOrderDto(order.getIdOrder());
                        })
        .collect(Collectors.toList());
    }

    @Override
    public String delete(String id) {
        Order order = helper(id);
        order.setDeleted(true);
        orderRepository.save(order);
        return "The order was deleted successfully";
    }
}
