package com.Order.order.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "orders")
@Entity
@ToString
public class Order {

    @Id
    private String idOrder;
    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
    private List<OrderLine> ordersLine;
    private String idUser;
    private boolean deleted;

}