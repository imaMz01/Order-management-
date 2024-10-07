package com.Order.order.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class OrderLine {

    @Id
    private String idOrderLine;
    private String idProduct;
    private int quantity;
    @ManyToOne
    private Order order;

}