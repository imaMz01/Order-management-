package com.Order.order.FeignClient;

import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Exceptions.FailedToFindService;
import com.Order.order.FeignClientReturn.GraphQLResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class ProductFallBack implements FallbackFactory<ProductFeign> {
    @Override
    public ProductFeign create(Throwable cause) {
        return new ProductFeign() {
            @Override
            public GraphQLResponse checkQuantity(String query) {
                throw  new FailedToFindService();
            }

            @Override
            public void decreaseStock(String query) {
                throw  new FailedToFindService();
            }
        };
    }
}
