package com.Order.order.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "orders")
@Entity
public class Order {

    @Id
    private String idOrder;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> ordersLine;
    private String idUser;

}