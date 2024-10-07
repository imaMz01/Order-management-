package com.Order.product.Controller;

import com.Order.product.Dtos.OrderLineDto;
import com.Order.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCommunicationController {

    private final ProductService productService;

    @PostMapping
    public boolean checkQuantity(@RequestBody List<OrderLineDto> orderLineDtoList){
        return productService.checkQuantity(orderLineDtoList);
    }

    @PutMapping
    public void decreaseStock(@RequestBody List<OrderLineDto> orderLineDtoList){
        productService.decreaseStock(orderLineDtoList);
    }

}
