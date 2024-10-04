package com.Order.User.Mappers;

import com.Order.User.Dtos.UserResponse;
import com.Order.User.Entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserResponseMapper {

    UserResponseMapper mapper = Mappers.getMapper(UserResponseMapper.class);
    UserResponse userToUserResponse(User user);
    User userResponseToUser(UserResponse userResponse);
    List<UserResponse> userToUserResponse(List<User> user);
    List<User> userResponseToUser(List<UserResponse> userResponse);
}
