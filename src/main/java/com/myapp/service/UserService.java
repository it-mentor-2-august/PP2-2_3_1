package com.myapp.service;

import com.myapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(UUID id);
    void createOrUpdateUser(User user);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(UUID id);
}
