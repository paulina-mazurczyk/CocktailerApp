package com.pauline.cocktailer.domain.edamam;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.pauline.cocktailer.domain.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class EdamamRecipe {

    @JsonAlias("label")
    private String title;

    private List<EdamamIngredient> ingredients;

    private Double calories;

    public static EdamamRecipe from(Recipe recipe) {
        EdamamRecipe edamamRecipe = new EdamamRecipe();
        edamamRecipe.setTitle(recipe.getTitle());
        edamamRecipe.setIngredients(EdamamIngredient.from(recipe.getIngredients()));
        edamamRecipe.setCalories(recipe.getCalories());
        return edamamRecipe;
    }
}
