package com.infoshareacademy;

import java.util.Scanner;

public class EditorRecipes {
    private Recipe recipe;

    public EditorRecipes(Recipe recipe) {
        this.recipe = recipe;
    }

    public void menu() {
        System.out.println("Wybierz co edytować:\n1. Nazwę\n2. Ocenę\n3. Anuluj");
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
