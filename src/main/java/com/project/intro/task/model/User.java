package com.project.intro.task.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
//@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String role;

    public User() {
    }
}
