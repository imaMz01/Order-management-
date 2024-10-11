package com.Order.order.Controller;

import com.Order.order.Dtos.OrderDto;
import com.Order.order.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order")
public class OrderController {

    private final OrderService orderService;
    private final StreamBridge streamBridge;

    @PostMapping("/add")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto){
        ResponseEntity<OrderDto> response = new ResponseEntity<>(orderService.add(orderDto), HttpStatus.CREATED);
        if(Objects.equals(response.getStatusCode(), HttpStatus.CREATED)){
            streamBridge.send("notification-topic",String.format("Order with id %s was placed successfully", response.getBody().getIdOrder()));
        }
        return response;
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
