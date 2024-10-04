package com.Order.User.Controllers;

import com.Order.User.Dtos.UserRequest;
import com.Order.User.Dtos.UserResponse;
import com.Order.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    public final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.add(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> all(){
        return  new ResponseEntity<>(userService.users(),HttpStatus.OK);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<UserResponse> userById(@PathVariable String id){
        return  new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        return  new ResponseEntity<>(userService.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest){
        return  new ResponseEntity<>(userService.update(userRequest),HttpStatus.OK);
    }

}
