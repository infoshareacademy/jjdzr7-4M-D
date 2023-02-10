package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.Recipe;
import com.infoshareacademy.four_md.service.RecipeFileHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RecipeController {

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("/saveRecipe")
    public String saveTask(@Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {

        if (bindResult.hasErrors()) {
            return "add-recipe";
        }
        deleteBlankIngredients(recipe);
        RecipeFileHandler recipeFileHandler = new RecipeFileHandler();
//        recipeFileHandler.save(recipe);
        model.addAttribute("recipe", recipe);
        System.out.println(recipe);
        return "confirmation";
    }

    private void deleteBlankIngredients(Recipe recipe) {
        recipe.getIngredientsList().removeIf(ingredients -> ingredients.getName().equals(""));
    }

}
