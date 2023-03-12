package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.StaticDtoMappers;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import com.infoshareacademy.four_md.service.jpaRepos.IngredientsRepository;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

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
    @Transactional
    public void save(Recipe recipe) {
        RecipeEntity entity = StaticDtoMappers.toEntity(recipe);
        save(entity);
        recipe.setId(entity.getId());
    }
    @Transactional
    public void save(RecipeEntity recipe) {
        ingredients.saveAll(recipe.getIngredientsList());
        ingredients.flush();
        recipes.saveAndFlush(recipe);
    }

    @Override
    public void remove(int recipeId) {
        recipes.deleteById(recipeId);
        recipes.flush(); //do I need to flush here ?
    }

    @Override
    @Transactional
    public Recipe get(int recipeId) {
        //noinspection OptionalGetWithoutIsPresent
        return StaticDtoMappers.toDto(recipes.findById(recipeId).get());
    }
}
