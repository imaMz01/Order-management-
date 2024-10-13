package com.Order.order.Dtos;

import com.Order.order.Validation.AddGroup;
import com.Order.order.Validation.UpdateGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {

    @Null(groups = AddGroup.class, message = "Order identifier must be null for add operations")
    @NotNull(groups = UpdateGroup.class, message = "Order identifier must not be null for update operations")
    private String idOrder;
    private List<OrderLineDto> ordersLine;
    private UserDto userDto;

}