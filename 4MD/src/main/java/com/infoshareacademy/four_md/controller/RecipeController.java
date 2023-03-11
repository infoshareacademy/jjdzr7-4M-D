package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {
    private final UserProvider userProvider;
    @GetMapping("/list")
    public String show(Model model) throws IOException {
        model.addAttribute("recipeList", getCurrentUser().getListOfRecipes());
        return "recipes-list";
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<ModelAndView> showRecipe(@PathVariable int id, Model model) throws IOException {
        Optional<Recipe> recipe = getCurrentUser().getListOfRecipes().stream().filter(s -> s.getId() == id).findFirst();
        if(recipe.isPresent()){
            ModelAndView view = new ModelAndView("recipe-details");
            view.addObject("recipe", recipe.get());
            return ResponseEntity.ok(view);
        }
        else {
            return ResponseEntity.notFound().build();
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

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable int id) throws IOException {
        User currentUser = getCurrentUser();
        currentUser.getListOfRecipes().removeIf(s -> s.getId() == id);
        userProvider.save(currentUser);

        return "redirect:/recipes/list";
    }

    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable int id, Model model) throws IOException {
        Recipe recipe = getCurrentUser().getListOfRecipes().get(id);
        model.addAttribute("recipe", recipe);
        return "edit-recipe";
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