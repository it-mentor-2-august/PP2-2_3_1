package com.myapp.model;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "webapp")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    @NotEmpty(message = "Name should be empty")
    @Size(min = 2, max = 30, message = "Name should be between from 2 to 30")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "age")
    @NotNull(message = "User's age cannot be null.")
    @Min(value = 18, message = "Age should be greater than 0")
    private Integer age;
    @NotEmpty(message = "Role should be empty")
    @Pattern(regexp = "^(User|Admin)$", message = "Role field must be either User or Admin")
    private String role;

    public User(String name, String email, Integer age, String role) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
