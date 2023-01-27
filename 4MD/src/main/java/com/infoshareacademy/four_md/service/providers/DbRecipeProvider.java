package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.entitiy.Recipe;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

//! TODO You know what to do
@Component
@Transactional
public class DbRecipeProvider implements RecipeProvider {
    @Override
    public void save(Recipe recipe) throws IOException {

    }

    @Override
    public void remove(int recipeId) throws IOException {

    }

    @Override
    public Recipe get(int recipeId) throws IOException {
        return null;
    }

    @Override
    public List<Recipe> getAll() throws IOException {
        return null;
    }
}
