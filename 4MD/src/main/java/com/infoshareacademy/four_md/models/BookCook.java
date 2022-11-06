package com.infoshareacademy.four_md.models;

import java.util.ArrayList;
import java.util.List;

public class BookCook {
    private User user;

    List<Recipe> recipes;

    List<Object> dataUser = new ArrayList<>();

    public void deleteRecipe(int i) {
        recipes.remove(i);
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<Object> displayDataUser() {
        dataUser.add(user.getId());
        dataUser.add(user.getName());
        dataUser.add(user.getSurname());
        dataUser.add(user.getListOfRecipes());
        return dataUser;
    }
}
