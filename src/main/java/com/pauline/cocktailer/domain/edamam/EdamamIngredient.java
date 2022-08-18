package com.pauline.cocktailer.domain.edamam;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.pauline.cocktailer.domain.Ingredient;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EdamamIngredient {

    @JsonAlias("food")
    private String name;

    private Double quantity;

    private String measure;

    private static EdamamIngredient from(Ingredient ingredient) {
        EdamamIngredient edamamIngredient = new EdamamIngredient();
        edamamIngredient.setName(ingredient.getName());
        edamamIngredient.setQuantity(ingredient.getQuantity());
        edamamIngredient.setMeasure(ingredient.getMeasure());
        return edamamIngredient;
    }

    public static List<EdamamIngredient> from(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(EdamamIngredient::from)
                .collect(Collectors.toList());
    }
}
