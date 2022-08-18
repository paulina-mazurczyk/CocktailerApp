package com.pauline.cocktailer.web;

import com.pauline.cocktailer.domain.edamam.EdamamRecipe;
import com.pauline.cocktailer.service.EdamamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails")
@RequiredArgsConstructor
public class EdamamController {

    private final EdamamService edamamService;

    @GetMapping
    public ResponseEntity<List<EdamamRecipe>> findAllByIngredients(@RequestParam("ingredients") String ingredients){
        return ResponseEntity.ok(edamamService.callForRecipes(ingredients));
    }
}
