/*
        in Main.java

        EditorRecipes editorRecipes = new EditorRecipes();
        editorRecipes.menu();
        editorRecipes.decisionMenu();
 */


package com.infoshareacademy;

import java.util.List;
import java.util.Scanner;

public class EditorRecipes {
    private Recipe recipe;
    private RecipesProvider recipesProvider;


    public EditorRecipes(Recipe recipe, RecipesProvider recipesProvider) {
        this.recipe = recipe;
        this.recipesProvider = recipesProvider;
    }

    public RecipesProvider getRecipesProvider() {
        return recipesProvider;
    }

    public void setRecipesProvider(RecipesProvider recipesProvider) {
        this.recipesProvider = recipesProvider;
    }

    public EditorRecipes() { recipe = getRecipe(); }

    public Recipe getRecipe() {
        return recipe;
    }

    public void menu() {
        System.out.print("Wybierz co edytować:\n" +
                "1. Nazwę\n" +
                //"2. Ocenę\n" +
                "3. Anuluj\n" +
                "Twój wybór to: ");
    }

    public void decisionMenu() {
        while (true) {
            if (choice() == 1) {
                recipeId();
                showCurrentName();
                newName();
                changeName();
                showCurrentName();
            } else if (choice() == 2) {
                //!!!!!
            } else if (choice() == 3) {
                break;

            } else
                System.out.println("Powinieneś wybrać jeszcze raz.");
        }
    }

    public void newName() {
        System.out.println("Podaj nową nazwę przepisu:");
    }

    public String addNewName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public void recipeId() {
        System.out.print("Podaj ID przepisu: ");
    }

    public int choice() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        return userChoice;
    }

    public String  showCurrentName() {
        RecipesProvider recipesProvider = new RecipesProvider();
        List<Recipe> list = recipesProvider.getRecipes();
        int index = choice() - 1;
        return list.get(index).getName();
    }

    public void changeName() {
        RecipesProvider recipesProvider1 = new RecipesProvider();
        List<Recipe> list = recipesProvider1.getRecipes();
        int index = list.indexOf(showCurrentName());
        list.set(index, addNewName());
    }

}
