package com.Order.order.Controller;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Dtos.OrderLineDto;
import com.Order.order.Dtos.UserDto;
import com.Order.order.FeignClient.UserFeign;
import com.Order.order.Services.OrderService;
import com.Order.order.Services.OrderServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.add(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> all(){
        return new ResponseEntity<>(orderService.all(),HttpStatus.OK);
    }

    @GetMapping("/orderById/{id}")
    public ResponseEntity<OrderDto> orderById(@PathVariable String id){
        return new ResponseEntity<>(orderService.orderById(id),HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        return new ResponseEntity<>(orderService.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.update(orderDto),HttpStatus.OK);
    }
}
