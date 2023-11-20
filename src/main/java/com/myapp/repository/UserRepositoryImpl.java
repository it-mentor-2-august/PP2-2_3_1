package com.myapp.repository;

import com.myapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void merge(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteById(UUID id) {
        Optional<User> user = findById(id);
        user.ifPresent(value -> entityManager.remove(value));
    }
}
