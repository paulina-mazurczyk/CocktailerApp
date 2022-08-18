package com.pauline.cocktailer.repository;

import com.pauline.cocktailer.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByUserUsername(String username);
}
