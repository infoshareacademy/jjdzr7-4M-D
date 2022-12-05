package com.infoshareacademy.four_md.repository;

import com.infoshareacademy.four_md.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Recipes {

    private final List<Recipe> recipes;

    public Recipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }


}
