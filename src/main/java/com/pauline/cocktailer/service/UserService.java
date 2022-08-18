package com.pauline.cocktailer.service;

import com.pauline.cocktailer.domain.User;
import com.pauline.cocktailer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByUsername(String username) {
        return repository.findById(username)
                .orElse(new User());
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(String username, User user) {
        user.setUsername(username);
        return repository.save(user);
    }

    public void delete(String username) {
        repository.deleteById(username);
    }
}
