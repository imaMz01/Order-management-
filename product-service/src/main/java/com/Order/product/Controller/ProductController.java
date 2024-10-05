package com.Order.product.Controller;

import com.Order.product.Entity.Product;
import com.Order.product.Service.ProductService;
import com.Order.product.codegen.types.ProductDTO;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @DgsMutation
    public Product addProduct(@RequestBody ProductDTO productDTO){
        return productService.add(productDTO);
    }

    @DgsQuery
    public Product productById(@PathVariable String id){
        return productService.productById(id);
    }

    @DgsQuery
    public List<Product> all(){
        return productService.all();
    }

    @DgsMutation
    public Product update(@Argument ProductDTO productDTO,@Argument String id){
        return productService.update(productDTO,id);
    }

    @DgsMutation
    public String delete(@Argument String id){
        return productService.delete(id);
    }

}
