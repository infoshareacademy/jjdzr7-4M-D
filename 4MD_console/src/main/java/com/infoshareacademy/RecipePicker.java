package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;

public class RecipePicker {
    private final List<Recipe> recipes;

    public RecipePicker(List<Recipe> recipes){

        this.recipes = recipes;
    }
    public Recipe activate() {
        int nameMaxLenght = getLongestLenght(this.recipes.stream().map(Recipe::getName).toArray());
        int foodTypeMaxLenght = getLongestLenght(this.recipes.stream().map(Recipe::getTypeOfFood).toArray());

        for (Recipe recipe:recipes) {
            System.out.println(describeRecipe(recipe,nameMaxLenght,foodTypeMaxLenght));
        }
        while(true){
            String input = getString("Enter recipe name: ");
            Object[] matches = recipes.stream().filter(recipe -> recipe.getName().equals(input)).toArray();
            if(matches.length == 1) return (Recipe) matches[0];
        }
    }
    private String describeRecipe(Recipe recipe, int nameMaxLenght, int foodTypeMaxLenght){
        String fName = spaceOutString(recipe.getName(),nameMaxLenght);
        String fType = spaceOutString(recipe.getTypeOfFood(),foodTypeMaxLenght);
        return String.format("%s type:%s kcal:%d",fName,fType,recipe.getKcal());
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
    private int getLongestLenght(Object[] strings){
        int recipeNameMaxLenght = 0;
        for (Object x : strings) {
            String xStr = (String)x;
            recipeNameMaxLenght = Math.max(recipeNameMaxLenght, xStr.length());
        }
        return recipeNameMaxLenght;
    }
}
