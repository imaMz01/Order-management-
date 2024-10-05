package com.Order.User.Service;

import com.Order.User.Configuration.Credentials;
import com.Order.User.Dtos.UserRequest;
import com.Order.User.Dtos.UserResponse;
import com.Order.User.Entites.User;
import com.Order.User.Exceptions.UserAlreadyExistException;
import com.Order.User.Exceptions.UserCreationException;
import com.Order.User.Exceptions.UserNotFoundException;
import com.Order.User.Mappers.UserRequestMapper;
import com.Order.User.Mappers.UserResponseMapper;
import com.Order.User.Repositories.UserRepository;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImp implements  UserService{

    @Value("${keycloak.realm}")
    public String realm;
    private final UserRepository userRepository;
    private Keycloak keycloak;

    public UserServiceImp(UserRepository userRepository, Keycloak keycloak) {
        this.userRepository = userRepository;
        this.keycloak = keycloak;
    }

    @Override
    public UserResponse add(UserRequest userRequest) {
        if(checkEmail(userRequest.getEmail())){
            throw  new UserAlreadyExistException(userRequest.getEmail());
        }
        User user = UserRequestMapper.mapper.userRequestToUser(userRequest);
        if( !createUser(user)){
            throw new UserCreationException();
        }
        user.setId(UUID.randomUUID().toString());
        return UserResponseMapper.mapper.userToUserResponse(
                userRepository.save(user)
        );
    }

    public boolean createUser(User userr) {
        UserRepresentation user=new UserRepresentation();
        user.setEnabled(true);
        user.setEmail(userr.getEmail());
        user.setUsername(userr.getUserName());
        user.setFirstName(userr.getFirstName());
        user.setLastName(userr.getLastName());
        user.setEmailVerified(false);

        CredentialRepresentation credential = Credentials.createPasswordCredentials(userr.getPassword());

        List<CredentialRepresentation> list =new ArrayList<>();
        list.add(credential);
        user.setCredentials(list);

        UsersResource usersResource = getUsersResource();

        Response response= usersResource.create(user);

        return Objects.equals(201, response.getStatus());
    }

    private UsersResource getUsersResource() {
        RealmResource realm1= keycloak.realm(realm);
        return realm1.users();
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
                () -> new UserNotFoundException(id)
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
