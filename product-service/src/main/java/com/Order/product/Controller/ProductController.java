package com.Order.product.Controller;

import com.Order.product.Dtos.OrderLineDto;
import com.Order.product.Entity.Product;
import com.Order.product.Service.ProductService;
import com.Order.product.codegen.types.ProductDTO;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @DgsMutation
    public Product addProduct(@InputArgument  ProductDTO productDTO){
        return productService.add(productDTO);
    }

    @DgsQuery
    public Product productById(@InputArgument String id){
        return productService.productById(id);
    }

    @DgsQuery
    public List<Product> all(){
        return productService.all();
    }

    @DgsMutation
    public Product update(@InputArgument ProductDTO productDTO,@InputArgument String id){
        return productService.update(productDTO,id);
    }

    @DgsMutation
    public String delete(@InputArgument String id){
        return productService.delete(id);
    }



}
