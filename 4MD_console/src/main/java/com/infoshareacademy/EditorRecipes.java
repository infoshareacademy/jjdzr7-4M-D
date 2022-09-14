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
        System.out.print("Wybierz co edytować:\n1. Nazwę\n2. Ocenę\n" +
                "3. Anuluj\nTwój wybór to: ");
    }

    public void newName() {
        System.out.println("Podaj nową nazwę przepisu:");
    }

    public String addNewName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public void decisionMenu() {
        if (choice() == 1) {
            recipeId();
            showCurrentName();
            newName();
            changeName();
            showCurrentName();
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

    public String  showCurrentName() {
        RecipesProvider recipesProvider = new RecipesProvider();
        List<Recipe> list = recipesProvider.getRecipes();
        return list.get(choice() - 1).getName();
    }

    public void changeName() {
        RecipesProvider recipesProvider1 = new RecipesProvider();
        List<Recipe> list = recipesProvider1.getRecipes();
        int index = list.indexOf(showCurrentName());
        //list.set(index, addNewName());
    }

}
