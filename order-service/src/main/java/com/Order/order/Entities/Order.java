package com.Order.order.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Order {

    private String idOrder;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> ordersLine;
    private String idUser;

}