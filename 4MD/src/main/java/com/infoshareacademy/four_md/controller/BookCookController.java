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

    @PostMapping(value = "/recipes")
    public RecipeEntity createNewRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipe.getName());
        newRecipe.setIngredientsList(recipe.getIngredientsList());
        newRecipe.setEstimatedCookingTime(recipe.getEstimatedCookingTime());
        newRecipe.setCalories(recipe.getCalories());
        newRecipe.setRatingsList(recipe.getRatingsList());
        newRecipe.setDifficulty(recipe.getDifficulty());
        newRecipe.setDishType(recipe.getDishType());

        return recipeRepository.save(newRecipe);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        Optional<RecipeEntity> optionalRecipeEntity = recipeRepository.findById(id)
                .map(recipeEntity -> {
                    recipeEntity.setName(recipe.getName());
                    recipeEntity.setIngredientsList(recipe.getIngredientsList());
                    recipeEntity.setEstimatedCookingTime(recipe.getEstimatedCookingTime());
                    recipeEntity.setCalories(recipe.getCalories());
                    recipeEntity.setRatingsList(recipe.getRatingsList());
                    recipeEntity.setDifficulty(recipe.getDifficulty());
                    recipeEntity.setDishType(recipe.getDishType());
                    return recipeEntity;
                })
                .map(recipeRepository::save);
        return ResponseEntity.of(optionalRecipeEntity);
    }


    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeRepository
                .findById(id)
                .ifPresent(recipeRepository::delete);
    }

}
