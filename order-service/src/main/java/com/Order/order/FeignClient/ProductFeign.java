package com.Order.order.FeignClient;



import com.Order.order.FeignClientReturn.GraphQLResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "product-service", fallbackFactory = ProductFallBack.class)
public interface ProductFeign {

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE)
    GraphQLResponse checkQuantity(@RequestBody String query);

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void decreaseStock(@RequestBody String query);
}
