package com.infoshareacademy.four_md.service.interfaces;

import com.infoshareacademy.four_md.model.entitiy.Recipe;

import java.io.IOException;
import java.util.List;

public interface RecipeProvider {
    void save(Recipe recipe) throws IOException;

    void remove(int recipeId) throws IOException;

    Recipe get(int recipeId) throws IOException;

    List<Recipe> getAll() throws IOException;
}
