package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.StaticDtoMappers;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import com.infoshareacademy.four_md.service.providers.DbRecipeProvider;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("recipes")
public class RecipeController {
    private DbRecipeProvider dbRecipeRepository;

    public RecipeController(DbRecipeProvider dbRecipeRepository) {
        this.dbRecipeRepository = dbRecipeRepository;
    }

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("/saveRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTask(@RequestBody @Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {
        if (bindResult.hasErrors()) {
            return "add-recipe";
        }
        dbRecipeRepository.save(recipe);
        model.addAttribute("recipeName", recipe.getName());
        return "confirmation";
    }

}