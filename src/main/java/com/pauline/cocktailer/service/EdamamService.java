package com.pauline.cocktailer.service;

import com.pauline.cocktailer.domain.edamam.EdamamRecipe;
import com.pauline.cocktailer.domain.edamam.EdamamResponse;
import com.pauline.cocktailer.domain.edamam.EdamamResult;
import com.pauline.cocktailer.web.client.EdamamClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EdamamService {

    private final EdamamClient edamamClient;

    public List<EdamamRecipe> callForRecipes(String ingredients) {
        EdamamResponse response = edamamClient.searchRecipesByIngredients(ingredients).getBody();
        return Optional.ofNullable(response)
                .map(EdamamResponse::getResults)
                .orElse(Collections.emptyList())
                .stream()
                .map(EdamamResult::getRecipe)
                .collect(Collectors.toList());
    }
}
