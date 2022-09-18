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
    private final Recipe recipe;
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
                "2. Ocenę\n" +
                "3. Anuluj\n" +
                "Twój wybór to: ");
    }

    public void decisionMenu() {
        boolean whileLoop = true;
        while (whileLoop == true) {
            switch (choice()) {
                case 1:
                    recipeId();
                    showCurrentName();
                    newName();
                    changeName();
                    showCurrentName();
                    break;
                case 2:
                    System.out.println("w produkcji");
                    //recipeId();
                    scoreId();
                    setScore();
                    System.out.println(scoreId());
                    break;
                case 3:
                    whileLoop = false;
                    break;
                default:
                    System.out.println("Błędny wybór!");
            }
        }
    }

    public void newName() {
        System.out.println("Podaj nową nazwę przepisu:");
    }

    public String addNewName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void recipeId() {
        System.out.print("Podaj ID przepisu: ");
    }

    public int choice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String  showCurrentName() {
        new RecipesProvider();
        List<Recipe> list = RecipesProvider.getRecipes();
        int index = choice() - 1;
        return list.get(index).getName();
    }

    public int searchName() {
        new RecipesProvider();
        List<Recipe> list = RecipesProvider.getRecipes();
        return list.indexOf(showCurrentName());
    }

    public int scoreId() {
        recipe.getId();
        return 0;
    }

    public int setScore () {
        System.out.print("Podaj ocenę: ");
        return setScore();
    }

    public void changeName() {
        new RecipesProvider();
        List<Recipe> list = RecipesProvider.getRecipes();
        list.set(choice() - 1, recipe.setName(addNewName()));
    }

}
