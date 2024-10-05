package com.Order.product.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product{

    @Id
    private String id;
    private String name;
    private String category;
    private double price;
    private int quantity;
}
