package com.infoshareacademy.four_md.service;

import com.infoshareacademy.four_md.model.dto.Ingredients;
import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.model.entitiy.IngredientsEntity;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.model.entitiy.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class StaticDtoMappers {
    public static UserEntity toEntity(User user){
        List<RecipeEntity> recipies = new ArrayList<>();
        user.getListOfRecipes().forEach(s -> recipies.add(toEntity(s)));
        return new UserEntity(user.getId(), user.getName(), user.getSurname(), recipies);
    }
    public static User toDto(UserEntity user){
        List<Recipe> recipies = new ArrayList<>();
        user.getListOfRecipes().forEach(s -> recipies.add(toDto(s)));
        return new User(user.getId(), user.getName(), user.getSurname(), recipies);
    }
    public static RecipeEntity toEntity( Recipe recipe){
        List<IngredientsEntity> list = new ArrayList<>();
        recipe.getIngredientsList().forEach(s -> list.add(toEntity(s)));
        return new RecipeEntity(recipe.getId(), recipe.getName(), list, recipe.getEstimatedCookingTime(),
                recipe.getCalories(), recipe.getRatingsList(),recipe.getDifficulty(),recipe.getDishType());
    }
    public static Recipe toDto( RecipeEntity recipe){
        List<Ingredients> list = new ArrayList<>();
        recipe.getIngredientsList().forEach(s -> list.add(toDto(s)));
        return new Recipe(recipe.getId(), recipe.getName(), list, recipe.getEstimatedCookingTime(),
                recipe.getCalories(), recipe.getRatingsList(),recipe.getDifficulty(),recipe.getDishType());
    }
    public static IngredientsEntity toEntity( Ingredients recipe){
        return new IngredientsEntity(recipe.getId(), recipe.getName(), recipe.getQuantity(), recipe.getUnit(), recipe.getPrice());
    }
    public static Ingredients toDto( IngredientsEntity recipe){
        Ingredients item =  new Ingredients(recipe.getName(), recipe.getQuantity(), recipe.getUnit(), recipe.getPrice());
        item.setId(recipe.getId());
        return item;
    }
}
