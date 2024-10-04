package com.Order.User.Dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRequest {

    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
