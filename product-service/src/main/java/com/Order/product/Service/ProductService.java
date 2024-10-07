package com.Order.product.Service;
import com.Order.product.Dtos.OrderLineDto;
import com.Order.product.Entity.Product;
import com.Order.product.codegen.types.ProductDTO;

import java.util.List;

public interface ProductService {

    Product add(ProductDTO productDTO);
    Product update(ProductDTO productDTO, String id);
    List<Product> all();
    Product productById(String id);
    String delete(String id);
    boolean checkQuantity(List<OrderLineDto> orderLineDtoList);
    void decreaseStock(List<OrderLineDto> orderLineDtoList);
}
