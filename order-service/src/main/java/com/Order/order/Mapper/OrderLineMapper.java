package com.Order.order.Mapper;

import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Entities.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    OrderLineMapper mapper = Mappers.getMapper(OrderLineMapper.class);
    OrderLineDto OrderLineToOrderLineDto(OrderLine orderLine);
    OrderLine OrderLineDtoToOrderLine(OrderLineDto orderLineDto);
    List<OrderLineDto> OrderLineToOrderLineDto(List<OrderLine> orderLine);
    List<OrderLine> OrderLineDtoToOrderLine(List<OrderLineDto> orderLineDto);
}
