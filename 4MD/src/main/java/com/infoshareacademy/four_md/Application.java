package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ranges.Range;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Ingredients ingredients = new Ingredients("cos", 1, Unit.GRAM, 5);
        Ingredients ingredients2 = new Ingredients("cos", 1, Unit.GRAM, 5);
        List<Ingredients> list = new ArrayList<>(List.of(ingredients, ingredients2));
        Recipe recipe = new Recipe(1,"name", list, 5, 2000, 5.0, Difficulty.LOW, DishType.DESSERT);
        System.out.println("koszt" + recipe.getCost());
        String answer = recipe.toString();
        System.out.println(answer);
        ValueRange range = ValueRange.of(1, 5);
        System.out.println(range.isValidIntValue(5));
    }

}
