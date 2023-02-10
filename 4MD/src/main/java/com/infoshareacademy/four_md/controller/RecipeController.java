package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.IOException;

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

    @PostMapping("/saveRecipe")
    public String saveTask(@RequestBody @Valid @ModelAttribute RecipeEntity recipeEntity, BindingResult bindResult, Model model) throws IOException {

        if (bindResult.hasErrors()) {
            return "add-recipe";
        }
        recipeRepository.save(recipeEntity);
        model.addAttribute("recipe", recipeEntity);

        return "confirmation";
    }

}
