package com.infoshareacademy.four_md.service;

import com.infoshareacademy.four_md.model.Recipe;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class RecipeFileHandler extends FileHandler<Recipe> implements RecipeProvider {

    public RecipeFileHandler() throws IOException {
        super("./recipes/", Recipe.class);
    }
}
