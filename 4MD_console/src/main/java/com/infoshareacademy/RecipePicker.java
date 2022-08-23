package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;

public class RecipePicker {
    private final List<Recipe> recipes;

    public RecipePicker(List<Recipe> recipes){

        this.recipes = recipes;
    }
    public Recipe activate() {
        int nameMaxLenght = getLongestRecipeNameLenght();
        for (Recipe recipe:recipes) {
            System.out.println(describeRecipe(recipe,nameMaxLenght));
        }
        while(true){
            String input = getString("Enter recipe name: ");
            Object[] matches = recipes.stream().filter(recipe -> recipe.getName().equals(input)).toArray();
            if(matches.length == 1) return (Recipe) matches[0];
        }
    }
    private String describeRecipe(Recipe recipe,int nameMaxLenght){
        return String.format("%s kcal:%d",spaceOutString(recipe.getName(),nameMaxLenght),recipe.getKcal());
    }
    private String spaceOutString(String text,int exceptedLenght){
        int spacesRequired = exceptedLenght-text.length();
        return text + " ".repeat(spacesRequired);
    }
    private String getString(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    private int getLongestRecipeNameLenght(){
        Object[] recipeNames = this.recipes.stream().map(Recipe::getName).toArray();
        int recipeNameMaxLenght = 0;
        for (Object x : recipeNames) {
            String xStr = (String)x;
            recipeNameMaxLenght = Math.max(recipeNameMaxLenght, xStr.length());
        }
        return recipeNameMaxLenght;
    }
}
