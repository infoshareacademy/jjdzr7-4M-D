package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {
    private final UserProvider userProvider;
    private final RecipeProvider recipeProvider;
    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("recipeList", getCurrentUser().getListOfRecipes());
        return "recipes-list";
    }

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable int id, Model model, HttpServletResponse response) {
        Optional<Recipe> recipe = getCurrentUser().getListOfRecipes().stream().filter(s -> s.getId() == id).findFirst();
        if(recipe.isPresent()){
            model.addAttribute("recipe", recipe.get());
            return "recipe-details";
        }
        else {
            response.setStatus(404);
            return null;
        }
    }

    @GetMapping("/add-recipe")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("save-recipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveRecipe(@RequestBody @Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {
        if (bindResult.hasErrors()) {
            return "add-recipe";
        }

        User currentUser = getCurrentUser();
        currentUser.getListOfRecipes().add(recipe);
        userProvider.save(currentUser);

        model.addAttribute("recipeName", recipe.getName());
        return "confirmation";
    }

    @PostMapping("/delete/{id}")
    public String deleteRecipe(@RequestBody @PathVariable int id, HttpServletResponse response) throws IOException {
        User currentUser = getCurrentUser();

        Optional<Recipe> recipeToRemove = currentUser.getListOfRecipes().stream().filter(s -> s.getId() == id).findFirst();
        if(recipeToRemove.isPresent()){
            Recipe recipe = recipeToRemove.get();
            currentUser.getListOfRecipes().remove(recipe);
            userProvider.save(currentUser);
            return "redirect:/recipes/list";
        }
        else {
            response.setStatus(404);
            return null;
        }

    }

    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable int id, Model model, HttpServletResponse response) {
        Optional<Recipe> recipe = getCurrentUser().getListOfRecipes().stream().filter(s -> s.getId() == id).findFirst();
        if(recipe.isPresent()){
            model.addAttribute("recipe", recipe.get());
            return "edit-recipe";
        }
        else {
            response.setStatus(404);
            return null;
        }

    }

    @PostMapping("edit/update-recipe/{id}")
    public String updateRecipe(@PathVariable int id, @RequestBody @Valid @ModelAttribute Recipe recipe, BindingResult bindResult, Model model) throws IOException {
        if (bindResult.hasErrors()) {
            return "edit-recipe";
        }
        recipe.setId(id);
        User currentUser = getCurrentUser();
        currentUser.getListOfRecipes().removeIf(s -> s.getId() == id);
        currentUser.getListOfRecipes().add(recipe);
        userProvider.save(currentUser);

        model.addAttribute("recipeName", recipe.getName());
        return "confirmation";
    }


    private User getCurrentUser(){
        return userProvider.findUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}