package com.Order.order.Mapper;

import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Entities.OrderLine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderLineMapper {

    OrderLineDto OrderLineToOrderLineDto(OrderLine orderLine);
    OrderLine OrderLineDtoToOrderLine(OrderLineDto orderLineDto);
    List<OrderLineDto> OrderLineToOrderLineDto(List<OrderLine> orderLine);
    List<OrderLine> OrderLineDtoToOrderLine(List<OrderLineDto> orderLineDto);
}
