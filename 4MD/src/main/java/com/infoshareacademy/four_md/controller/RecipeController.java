package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.IngredientsEntity;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {
    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        RecipeEntity recipeEntity = new RecipeEntity();
        model.addAttribute("recipe", recipeEntity);
        return "add-recipe";
    }

//    @PostMapping("/saveRecipe")
//    public String saveTask(@RequestBody @Valid @ModelAttribute RecipeEntity recipeEntity, BindingResult bindResult, Model model) throws IOException {
//        if (bindResult.hasErrors()) {
//            return "add-recipe";
//        }
//        recipeRepository.save(recipeEntity);
//        model.addAttribute("recipe", recipeEntity);
//        return "confirmation";
//    }

    @PostMapping(value = "/saveRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    private String saveTask(@RequestBody @Valid @ModelAttribute Recipe recipeDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-recipe";
        }
        model.addAttribute("recipe", recipeDTO);
        RecipeEntity newRecipeEntity = new RecipeEntity();
        IngredientsEntity newIngredientsEntity = new IngredientsEntity();
        List<IngredientsEntity> ingredientsList = new ArrayList<>();
        newRecipeEntity.setName(recipeDTO.getName());
        newRecipeEntity.setMethod(recipeDTO.getMethod());
        newRecipeEntity.setEstimatedCookingTime(recipeDTO.getEstimatedCookingTime());
        newRecipeEntity.setCalories(recipeDTO.getCalories());
        newRecipeEntity.setDishType(recipeDTO.getDishType());
        newRecipeEntity.setDifficulty(recipeDTO.getDifficulty());

        newIngredientsEntity.setName(recipeDTO.getIngredientsList().get(0).getName());
        newIngredientsEntity.setPrice(recipeDTO.getIngredientsList().get(0).getPrice());
        newIngredientsEntity.setQuantity(recipeDTO.getIngredientsList().get(0).getQuantity());
        newIngredientsEntity.setUnit(recipeDTO.getIngredientsList().get(0).getUnit());
        ingredientsList.add(newIngredientsEntity);

        newRecipeEntity.setIngredientsList(ingredientsList);
        recipeRepository.save(newRecipeEntity);

        return "confirmation";

    }

}
