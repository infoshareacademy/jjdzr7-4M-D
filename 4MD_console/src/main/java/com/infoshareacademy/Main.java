package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(0,"minecraft",new ArrayList<>(),0,0,660,10,"gra"));
        recipes.add(new Recipe(1,"kawa",new ArrayList<>(),0,0,60,10,"jedzenie"));
        recipes.add(new Recipe(2,"spagetti",new ArrayList<>(),0,0,1000,10,"Test_food"));
        recipes.add(new Recipe(3,"asdxczefr2efefefwwq",new ArrayList<>(),0,0,200,10,"Test_food"));
        RecipePicker picker = new RecipePicker(recipes);
        Recipe recipe = picker.activate();
        System.out.println(recipe.getName());
    }
}
