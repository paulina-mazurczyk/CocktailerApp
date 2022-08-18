package com.pauline.cocktailer.service;

import com.pauline.cocktailer.domain.Recipe;
import com.pauline.cocktailer.domain.User;
import com.pauline.cocktailer.domain.edamam.EdamamRecipe;
import com.pauline.cocktailer.repository.RecipeRepository;
import com.pauline.cocktailer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final UserRepository userRepository;

    public List<EdamamRecipe> getAllByUser(String username) {
        return repository.findAllByUserUsername(username)
                .stream()
                .map(EdamamRecipe::from)
                .collect(Collectors.toList());
    }

    public EdamamRecipe getById(Long id) {
        return repository.findById(id)
                .map(EdamamRecipe::from)
                .orElse(new EdamamRecipe());
    }

    @Transactional
    public EdamamRecipe saveForUser(String username, EdamamRecipe recipe) {
        User user = userRepository.findById(username)
                .orElse(new User());
        return EdamamRecipe.from(repository.save(Recipe.from(recipe, user)));
    }

    public EdamamRecipe update(Long id, String username, EdamamRecipe recipe) {
        Optional<User> user = repository.findById(id)
                .map(Recipe::getUser);
        boolean isNotValidUser = user.map(User::getUsername)
                .filter(username::equals)
                .isEmpty();
        if (isNotValidUser) {
            throw new IllegalArgumentException(
                    String.format("Given username %s is not assigned to recipe with id: %d", username, id));
        }
        return EdamamRecipe.from(repository.save(Recipe.from(recipe, id, user.get())));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
