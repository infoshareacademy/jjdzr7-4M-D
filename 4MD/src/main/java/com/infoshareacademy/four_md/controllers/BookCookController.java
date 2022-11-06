package com.infoshareacademy.four_md.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;

@RestController
@RequestMapping("/BookCook")
public class BookCookController {
    private RecipeProvider recipeProvider;

    public BookCookController(RecipeProvider recipeProvider) {
        this.recipeProvider = recipeProvider;
        
    }

    @GetMapping("{id}")
    public Recipe getRecipe(@PathVariable int id) throws IOException{
            return recipeProvider.get(id);
    }
    @GetMapping("all")
    public List<Recipe> getRecipes() throws IOException{
            return recipeProvider.getAll();
    }
    @PostMapping()
    public void addRecipe(@RequestBody Recipe recipe) throws IOException{
        recipeProvider.save(recipe);
    }
    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable int id) throws IOException{
        recipeProvider.remove(id);
    }
}
