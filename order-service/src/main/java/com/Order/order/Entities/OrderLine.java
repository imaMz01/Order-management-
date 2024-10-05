package com.Order.order.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class OrderLine {

    private String idOrderLine;
    private String idProduct;
    private int quantity;
    @ManyToOne
    private Order order;

}