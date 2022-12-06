package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.Ingredients;
import com.infoshareacademy.four_md.model.Ratings;
import com.infoshareacademy.four_md.model.Recipe;
import com.infoshareacademy.four_md.repository.Recipes;
import com.infoshareacademy.four_md.service.RecipeFileHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddRecipe {
    private final Recipes recipes;

    public AddRecipe(Recipes recipes) {
        this.recipes = recipes;
    }

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("/saveRecipe")
    public String saveTask(@Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) {

        if (bindResult.hasErrors()) {
            return "add-recipe";
        }
        recipes.getRecipes().add(recipe);
        model.addAttribute("recipe", recipe);
        System.out.println(recipe);
        return "confirmation";
    }

}
