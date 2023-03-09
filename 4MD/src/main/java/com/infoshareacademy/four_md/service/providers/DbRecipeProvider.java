package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.StaticDtoMappers;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import com.infoshareacademy.four_md.service.jpaRepos.IngredientsRepository;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//! TODO You know what to do
@Component
public class DbRecipeProvider implements RecipeProvider {
    private final RecipeRepository recipes;
    private final IngredientsRepository ingredients;

    public DbRecipeProvider(RecipeRepository recipes, IngredientsRepository ingredients){
        this.recipes = recipes;

        this.ingredients = ingredients;
    }
    @Override
    public void save(Recipe recipe) throws IOException {
        RecipeEntity entity = StaticDtoMappers.toEntity(recipe);
        save(entity);
        recipe.setId(entity.getId());
    }
    @Transactional
    public void save(RecipeEntity recipe) throws IOException {
        for (var ingredient : recipe.getIngredientsList()) {
            ingredients.save(ingredient);
        }
        ingredients.flush();
        recipes.saveAndFlush(recipe);
    }

    @Override
    public void remove(int recipeId) throws IOException {
        recipes.deleteById(recipeId);
        recipes.flush(); //do I need to flush here ?
    }

    @Override
    @Transactional
    public Recipe get(int recipeId) throws IOException {
        //noinspection OptionalGetWithoutIsPresent
        return StaticDtoMappers.toDto(recipes.findById(recipeId).get());
    }

    @Transactional
    public List<Recipe> getAll() throws IOException {
        //noinspection OptionalGetWithoutIsPresent
        return recipes.findAll().stream()
                .map(s -> StaticDtoMappers.toDto(s))
                .collect(Collectors.toList());
    }

    @Transactional
    public Recipe update(Recipe recipe) {
        RecipeEntity entityToUpdate = recipes.findById(recipe.getId())
                .orElseThrow(() -> new RuntimeException("Cannot find"));
        return StaticDtoMappers.toDto(entityToUpdate);
    }
}
