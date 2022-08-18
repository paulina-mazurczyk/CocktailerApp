package com.pauline.cocktailer.domain;

import com.pauline.cocktailer.domain.edamam.EdamamIngredient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //food

    private Double quantity;

    private String measure;

    private static Ingredient from(EdamamIngredient edamamIngredient){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(edamamIngredient.getName());
        ingredient.setQuantity(edamamIngredient.getQuantity());
        ingredient.setMeasure(edamamIngredient.getMeasure());
        return ingredient;
    }

    public static List<Ingredient> from(List<EdamamIngredient> edamamIngredients){
        return edamamIngredients.stream()
                .map(Ingredient::from)
                .collect(Collectors.toList());
    }
}
