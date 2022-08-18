package com.pauline.cocktailer.web;

import com.pauline.cocktailer.domain.edamam.EdamamRecipe;
import com.pauline.cocktailer.service.RecipeService;
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
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService service;

    @GetMapping("/users/{username}")
    public ResponseEntity<List<EdamamRecipe>> getAll(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.getAllByUser(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EdamamRecipe> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/users/{username}")
    public ResponseEntity<EdamamRecipe> addNew(
            @PathVariable("username") String username, @RequestBody EdamamRecipe recipe) {
        return ResponseEntity.ok(service.saveForUser(username, recipe));
    }

    @PutMapping("/{id}/users/{username}")
    public ResponseEntity<EdamamRecipe> update(
            @PathVariable("id") Long id, @PathVariable("username") String username, @RequestBody EdamamRecipe recipe) {
        return ResponseEntity.ok(service.update(id, username, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
