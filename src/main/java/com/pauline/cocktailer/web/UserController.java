package com.pauline.cocktailer.web;

import com.pauline.cocktailer.domain.User;
import com.pauline.cocktailer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getOne(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @PostMapping
    public ResponseEntity<User> addNew(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> update(@PathVariable("username") String username, @RequestBody User user) {
        return ResponseEntity.ok(service.update(username, user));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> delete(@PathVariable("username") String username) {
        service.delete(username);
        return ResponseEntity.ok().build();
    }
}
