package com.infoshareacademy;

import java.util.Scanner;

public class EditorRecipes {
    private Recipe recipe;

    public EditorRecipes(Recipe recipe) {
        this.recipe = recipe;
    }

    public EditorRecipes() { recipe = getRecipe(); }

    public Recipe getRecipe() {
        return recipe;
    }

    public void menu() {
        System.out.print("Wybierz co edytować:\n1. Nazwę\n2. Ocenę\n" +
                "3. Anuluj\nTwój wybór to: ");
    }

    public void decisionMenu() {
        if (choice() == 1) {
            recipeId();
            choice();
        } else if (choice() == 2) {
            recipeId();
            choice();
        } else if (choice() == 3) {
            //!!!!!!!!!!!!!!!!!!!!!!
            System.out.println("");
        }
        else
            System.out.println("Powinieneś wybrać jeszcze raz.");
    }

    public void recipeId() {
        System.out.print("Podaj ID przepisu: ");
    }

    public int choice() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        return userChoice;
    }

    public void showCurrentName() {
        this.recipe.getName();
    }

}
