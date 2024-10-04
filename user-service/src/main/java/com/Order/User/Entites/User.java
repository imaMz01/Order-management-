package com.Order.User.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Utilisateur")
public class User {

    @Id
    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
