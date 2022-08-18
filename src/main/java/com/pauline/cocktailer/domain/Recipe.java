package com.pauline.cocktailer.domain;

import com.pauline.cocktailer.domain.edamam.EdamamRecipe;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; //label

    private Double calories;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Ingredient> ingredients;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private User user;

    public static Recipe from(EdamamRecipe edamamRecipe){
        Recipe recipe = new Recipe();
        recipe.setTitle(edamamRecipe.getTitle());
        recipe.setCalories(edamamRecipe.getCalories());
        recipe.setIngredients(Ingredient.from(edamamRecipe.getIngredients()));
        return recipe;
    }

    public static Recipe from(EdamamRecipe edamamRecipe, Long id, User user){
        Recipe recipe = from(edamamRecipe);
        recipe.setId(id);
        recipe.setUser(user);
        return recipe;
    }

    public static Recipe from(EdamamRecipe edamamRecipe, User user){
        Recipe recipe = from(edamamRecipe);
        recipe.setUser(user);
        return recipe;
    }
}
