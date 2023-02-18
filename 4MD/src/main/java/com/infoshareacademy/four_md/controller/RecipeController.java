package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.IngredientsEntity;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.IngredientsRepository;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import com.infoshareacademy.four_md.service.mappers.RecipeMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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
        RecipeEntity recipeEntity = RecipeMapper.toEntity(recipe);
        recipeRepository.save(recipeEntity);
        model.addAttribute("recipe", recipeEntity);
        return "confirmation";
    }

}
