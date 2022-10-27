package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@SpringBootConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Ingredients ingredients = new Ingredients("cukier", 10, Unit.GRAM, 5);
        Ingredients ingredients2 = new Ingredients("sol", 15, Unit.GRAM, 5);
        List<Ingredients> list = new ArrayList<>(List.of(ingredients, ingredients2));
        Recipe recipe = new Recipe(1,"name", list, 5, 2000, List.of(1,5,2,3), Difficulty.LOW, DishType.DESSERT);
        String answer = recipe.toString();
        System.out.println(answer);
        recipe.setRatings(List.of(-1, 2));
        System.out.println(recipe);
//        recipe.ingredientsListByPortion(4);
//        recipe.ingredientsListByPortion(5);
//        System.out.println(recipe.ingredientsListByPortion(5));
//        System.out.println(recipe.ingredientsListByPortion(4));
    }

}
