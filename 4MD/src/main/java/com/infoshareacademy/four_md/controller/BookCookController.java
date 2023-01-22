package com.infoshareacademy.four_md.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookCook")
public class BookCookController {
//    private RecipeProvider recipeProvider;
//
//    public BookCookController(RecipeProvider recipeProvider) {
//        this.recipeProvider = recipeProvider;
//
//    }
//
//    @GetMapping("/{id}")
//    public Recipe getRecipe(@PathVariable int id) throws IOException{
//            return recipeProvider.get(id);
//    }
//    @GetMapping("/all")
//    public List<Recipe> getRecipes() throws IOException{
//            return recipeProvider.getAll();
//    }
//    @PostMapping()
//    public void addRecipe(@RequestBody Recipe recipe) throws IOException{
//        recipeProvider.save(recipe);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteRecipe(@PathVariable int id) throws IOException{
//        recipeProvider.remove(id);
//    }
}
