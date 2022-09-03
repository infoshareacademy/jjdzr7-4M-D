package com.infoshareacademy;

import java.util.List;

public class UserRecipeManager {
    private List<Recipe> userRecipes;

    public UserRecipeManager(List<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public void addRecipeToUserRecipes(Recipe recipe) {
        this.userRecipes.add(recipe);
    }

    public void deleteRecipeFromUserRecipes(Recipe recipe) {
        this.userRecipes.remove(recipe);
    }

    public List<Recipe> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(List<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }
}
