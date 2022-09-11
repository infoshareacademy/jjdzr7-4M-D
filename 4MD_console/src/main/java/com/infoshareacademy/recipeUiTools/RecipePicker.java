package com.infoshareacademy.recipeUiTools;

import com.infoshareacademy.Recipe;

import java.util.List;
import java.util.Scanner;

public class RecipePicker {
    private final List<Recipe> recipes;
    Scanner input = new Scanner(System.in);

    public RecipePicker(List<Recipe> recipes) {

        this.recipes = recipes;
    }

    public Recipe activate() {
        TableBuilder builder = new TableBuilder(5);

        for (Recipe recipe : recipes) {
            builder.AddRow(new String[]{
                    recipe.getName(),
                    "Rodzaj:", recipe.getTypeOfFood(),
                    "Kcal:", String.valueOf(recipe.getKcal())
            });
        }
        System.out.print(builder.build());
        while (true) {
            String input = getRecipeNameFromScanner();
            Object[] matches = recipes.stream().filter(recipe -> recipe.getName().equals(input)).toArray();
            if (matches.length == 1) return (Recipe) matches[0];
        }
    }

    private String getRecipeNameFromScanner() {

        System.out.print("Wpisz nazwę receptury: ");
        return input.nextLine();
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
