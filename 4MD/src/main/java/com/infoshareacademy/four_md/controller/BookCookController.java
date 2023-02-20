package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/BookCook")
@RequiredArgsConstructor
public class BookCookController {

    private final RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeEntity> getRecipeById(@PathVariable int id) {
        return ResponseEntity.of(recipeRepository.findById(id));
    }


}
