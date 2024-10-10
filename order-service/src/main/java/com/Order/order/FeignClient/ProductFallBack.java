package com.Order.order.FeignClient;

import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Exceptions.FailedToFindService;
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
            public boolean checkQuantity(List<OrderLineDto> orderLineDtoList) {
                log.info("Ouups Something went wrong !!!");
                throw  new FailedToFindService();
            }

            @Override
            public void decreaseStock(List<OrderLineDto> orderLineDtoList) {
                throw  new FailedToFindService();
            }
        };
    }
}
