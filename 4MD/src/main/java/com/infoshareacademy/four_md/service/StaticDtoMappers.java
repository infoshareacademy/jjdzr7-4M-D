package com.infoshareacademy.four_md.service;

import com.infoshareacademy.four_md.model.dto.Ingredients;
import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.model.entitiy.IngredientsEntity;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.model.entitiy.UserEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StaticDtoMappers {
    public static UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getSurname(),
                user.getListOfRecipes().stream().map(StaticDtoMappers::toEntity).collect(Collectors.toList()));
    }
    public static User toDto(UserEntity user){
        return new User(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getSurname(),
                user.getListOfRecipes().stream().map(StaticDtoMappers::toDto).collect(Collectors.toList()));
    }
    public static RecipeEntity toEntity( Recipe recipe){
        return new RecipeEntity(
                recipe.getId(),
                recipe.getName(),
                recipe.getPreparationMethod(),
                recipe.getIngredientsList().stream().map(StaticDtoMappers::toEntity).collect(Collectors.toList()),
                recipe.getEstimatedCookingTime(),
                recipe.getCalories(),
                recipe.getRatingsList(),
                recipe.getDifficulty(),
                recipe.getDishType());
    }
    public static Recipe toDto( RecipeEntity recipe){
        return new Recipe(
                recipe.getId(),
                recipe.getName(),
                recipe.getPreparationMethod(),
                recipe.getIngredientsList().stream().map(StaticDtoMappers::toDto).collect(Collectors.toList()),
                recipe.getEstimatedCookingTime(),
                recipe.getCalories(),
                new ArrayList<>(recipe.getRatingsList()), // Dumping Ratings list to keep them away from LAZYException
                recipe.getDifficulty(),
                recipe.getDishType());
    }
    public static IngredientsEntity toEntity( Ingredients recipe){
        return new IngredientsEntity(
                recipe.getId(),
                recipe.getName(),
                recipe.getQuantity(),
                recipe.getUnit(),
                recipe.getPrice());
    }
    public static Ingredients toDto( IngredientsEntity recipe){
        Ingredients item =  new Ingredients(recipe.getName(), recipe.getQuantity(), recipe.getUnit(), recipe.getPrice());
        item.setId(recipe.getId());
        return item;
    }
}
