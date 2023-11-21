package com.myapp.repository;

import com.myapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(UUID id);
    void save(User user);
    void merge(User user);
    void deleteById(UUID id);
}
