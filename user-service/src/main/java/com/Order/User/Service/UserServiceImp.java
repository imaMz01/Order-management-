package com.Order.User.Service;

import com.Order.User.Dtos.UserRequest;
import com.Order.User.Dtos.UserResponse;
import com.Order.User.Entites.User;
import com.Order.User.Exceptions.UserAlreadyExistException;
import com.Order.User.Exceptions.UserNotFoundException;
import com.Order.User.Mappers.UserRequestMapper;
import com.Order.User.Mappers.UserResponseMapper;
import com.Order.User.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements  UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse add(UserRequest userRequest) {
        if(checkEmail(userRequest.getEmail())){
            throw  new UserAlreadyExistException();
        }
        User user = UserRequestMapper.mapper.userRequestToUser(userRequest);
        user.setId(UUID.randomUUID().toString());
        return UserResponseMapper.mapper.userToUserResponse(
                userRepository.save(user)
        );

    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        User user = helper(userRequest.getId());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        return UserResponseMapper.mapper.userToUserResponse(
                userRepository.save(user)
        );
    }

    @Override
    public List<UserResponse> users() {
        return UserResponseMapper.mapper.userToUserResponse(
                userRepository.findAll()
        );
    }

    public boolean checkEmail(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    public User helper(String id){
        return userRepository.findById(id).orElseThrow(
                UserNotFoundException::new
        );
    }
    @Override
    public String delete(String id) {
        userRepository.delete(helper(id));
        return "User deleted";
    }

    @Override
    public UserResponse getById(String id) {
        return UserResponseMapper.mapper.userToUserResponse(helper(id));
    }
}
