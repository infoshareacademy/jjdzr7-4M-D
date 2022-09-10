package com.infoshareacademy.recipeUiTools;

import com.infoshareacademy.Recipe;

import java.util.List;
import java.util.Scanner;

public class RecipePicker {
    private final List<Recipe> recipes;
    Scanner input = new Scanner(System.in);

    public RecipePicker(List<Recipe> recipes){

        this.recipes = recipes;
    }
    public Recipe activate() {
        TableBuilder builder = new TableBuilder(3);

        for (Recipe recipe:recipes) {
            builder.AddRow(new String[]{
                    recipe.getName(),
                    "type:"+recipe.getTypeOfFood(),
                    "kcal:"+recipe.getKcal()
            });
        }
        builder.printTable();
        while(true){
            String input = getString("Enter recipe name: ");
            Object[] matches = recipes.stream().filter(recipe -> recipe.getName().equals(input)).toArray();
            if(matches.length == 1) return (Recipe) matches[0];
        }
    }
    private String getString(String prompt){

        System.out.print(prompt);
        return input.nextLine();
    }
    public void setInput(Scanner input) {
        this.input = input;
    }
}
