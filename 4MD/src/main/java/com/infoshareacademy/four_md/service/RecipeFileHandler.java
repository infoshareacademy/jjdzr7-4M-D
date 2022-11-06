package com.infoshareacademy.four_md.service;

import com.google.gson.Gson;
import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
@Component
public class RecipeFileHandler extends FileHandler<Recipe> implements RecipeProvider {

    public RecipeFileHandler() throws IOException {
        super("./recipes/", Recipe.class);
    }

    @Override
    public Recipe get(int Id) throws IOException {
        return super.get(Id);
    }

    @Override
    public List<Recipe> getAll() throws IOException {
        return super.getAll();
    }

    @Override
    public void remove(int Id) throws IOException {
        super.remove(Id);
    }

    @Override
    public void save(Recipe recipe) throws IOException {
        super.save(recipe, recipe.getId());
    }
    
}
