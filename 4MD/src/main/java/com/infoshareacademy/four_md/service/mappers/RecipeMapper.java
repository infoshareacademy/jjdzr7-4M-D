package com.infoshareacademy.four_md.service.mappers;

import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;

public class RecipeMapper {

    public static RecipeEntity toEntity(Recipe recipe) {
        RecipeEntity entity = new RecipeEntity();
        entity.setId(recipe.getId());
        entity.setName(recipe.getName());
        entity.setMethod(recipe.getMethod());
        entity.setIngredientsList(IngredientsMapper.toEntityList(recipe.getIngredientsList()));
        entity.setEstimatedCookingTime(recipe.getEstimatedCookingTime());
        entity.setCalories(recipe.getCalories());
        entity.setRatingsList(recipe.getRatingsList());
        entity.setDifficulty(recipe.getDifficulty());
        entity.setDishType(recipe.getDishType());
        return entity;
    }

    public static Recipe toModel(RecipeEntity entity) {
        Recipe recipe = new Recipe();
        recipe.setId(entity.getId());
        recipe.setName(entity.getName());
        recipe.setMethod(entity.getMethod());
        recipe.setIngredientsList(IngredientsMapper.toModelList(entity.getIngredientsList()));
        recipe.setEstimatedCookingTime(entity.getEstimatedCookingTime());
        recipe.setCalories(entity.getCalories());
        recipe.setRatingsList(entity.getRatingsList());
        recipe.setDifficulty(entity.getDifficulty());
        recipe.setDishType(entity.getDishType());
        return recipe;
    }

}
