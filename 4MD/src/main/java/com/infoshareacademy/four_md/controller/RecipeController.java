package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.service.providers.DbRecipeProvider;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RecipeController {
    private DbRecipeProvider dbRecipeRepository;

    public RecipeController(DbRecipeProvider dbRecipeRepository) {
        this.dbRecipeRepository = dbRecipeRepository;
    }

    @GetMapping("/list")
    public String show(Model model) throws IOException {
        model.addAttribute("recipeList", dbRecipeRepository.getAll());
        return "recipes-list";
    }

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable int id, Model model) throws IOException {
        Recipe recipe = dbRecipeRepository.get(id);
        model.addAttribute("recipe", recipe);
        return "recipe-details";
    }

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("/saveRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveRecipe(@RequestBody @Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {
        if (bindResult.hasErrors()) {
            return "add-recipe";
        }
        dbRecipeRepository.save(recipe);
        model.addAttribute("recipeName", recipe.getName());
        return "confirmation";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable int id) throws IOException {
        dbRecipeRepository.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable int id, Model model) throws IOException {
        Recipe recipe = dbRecipeRepository.get(id);
        model.addAttribute("recipe", recipe);
        return "edit-recipe";
    }

    @PostMapping("/updateRecipe/{id}")
    public String updateRecipe(@PathVariable int id, @RequestBody @Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {
        if (bindResult.hasErrors()) {
            return "edit-recipe";
        }
        recipe.setId(id);
        dbRecipeRepository.save(recipe);
        model.addAttribute("recipeName", recipe.getName());
        return "confirmation";
    }


}