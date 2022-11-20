package com.infoshareacademy.four_md.model;

import com.infoshareacademy.four_md.models.User;

import java.util.ArrayList;
import java.util.List;

public class BookCook {

    List<Recipe> recipes;

    public void deleteRecipe(int i) {
        recipes.remove(i);
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<Object> displayDataUser(User user) {
        List<Object> dataUser = new ArrayList<>();
        dataUser.add(user.getId());
        dataUser.add(user.getName());
        dataUser.add(user.getSurname());
        dataUser.add(user.getListOfRecipes());
        return dataUser;
    }
}
