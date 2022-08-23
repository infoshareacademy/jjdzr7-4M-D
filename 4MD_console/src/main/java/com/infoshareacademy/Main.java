package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("test123",100));
        recipes.add(new Recipe("kawa mrozona",500));
        recipes.add(new Recipe("minecraft",660));
        RecipePicker picker = new RecipePicker(recipes);
        Recipe recipe = picker.activate();
        System.out.println(recipe.getName());
    }
}
