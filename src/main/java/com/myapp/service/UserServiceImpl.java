package com.myapp.service;

import com.myapp.model.User;
import com.myapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void createOrUpdateUser(User user) {
        if (user.getId() == null) userRepository.save(user);
        else {
            userRepository.merge(user);
        }
    }
    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }
    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
