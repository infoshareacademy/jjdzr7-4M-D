package com.infoshareacademy.four_md.service.mappers;

import com.infoshareacademy.four_md.model.Unit;
import com.infoshareacademy.four_md.model.dto.Ingredients;
import com.infoshareacademy.four_md.model.entitiy.IngredientsEntity;

import java.util.List;
import java.util.stream.Collectors;

public class IngredientsMapper {

    public static IngredientsEntity toEntity(Ingredients ingredient) {
        IngredientsEntity entity = new IngredientsEntity();
        entity.setId(ingredient.getId());
        entity.setName(ingredient.getName());
        entity.setQuantity(ingredient.getQuantity());
        entity.setUnit(ingredient.getUnit());
        entity.setPrice(ingredient.getPrice());
        return entity;
    }

    public static Ingredients toModel(IngredientsEntity entity) {
        Ingredients ingredient = new Ingredients();
        ingredient.setId(entity.getId());
        ingredient.setName(entity.getName());
        ingredient.setQuantity(entity.getQuantity());
        ingredient.setUnit(entity.getUnit());
        ingredient.setPrice(entity.getPrice());
        return ingredient;
    }

    public static List<IngredientsEntity> toEntityList(List<Ingredients> ingredients) {
        return ingredients.stream().map(ingredient -> IngredientsMapper.toEntity(ingredient)).collect(Collectors.toList());
    }

    public static List<Ingredients> toModelList(List<IngredientsEntity> entities) {
        return entities.stream().map(IngredientsMapper::toModel).collect(Collectors.toList());
    }

}