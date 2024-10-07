package com.Order.product.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLineDto{

    private String idOrderLine;
    private String idProduct;
    private int quantity;

    private String idOrder;

}