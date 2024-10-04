package com.Order.User.Service;

import com.Order.User.Dtos.UserRequest;
import com.Order.User.Dtos.UserResponse;
import com.Order.User.Entites.User;

import java.util.List;

public interface UserService {

    UserResponse add(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    List<UserResponse> users();
    String delete(String id);
    UserResponse getById(String id);


}
