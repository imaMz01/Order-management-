package com.Order.User.Mappers;

import com.Order.User.Dtos.UserRequest;
import com.Order.User.Entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserRequestMapper {

    UserRequestMapper mapper = Mappers.getMapper(UserRequestMapper.class);
    UserRequest userToUserRequest(User user);
    User userRequestToUser(UserRequest userRequest);
    List<UserRequest> userToUserRequest(List<User> user);
    List<User> userRequestToUser(List<UserRequest> userRequest);
}
