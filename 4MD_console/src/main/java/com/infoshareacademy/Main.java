package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        

        UserSingleton userSingleton = UserSingleton.getInstance("Robert", "Maklowicz", list, list2);
        UserSingleton userSingleton1 = UserSingleton.getInstance("Mietek", "Maklowicz", list, list2);
        System.out.println(userSingleton.getFirstName() + userSingleton.getSecondName() + userSingleton.getUserRecipes() + userSingleton.getUserScores());
        UserRecipeManager userRecipeManager = new UserRecipeManager(userSingleton.getUserRecipes());
        userRecipeManager.addRecipeToUserRecipes(recipe);
        userRecipeManager.addRecipeToUserRecipes(recipe3);
        userRecipeManager.addRecipeToUserRecipes(recipe2);
        System.out.println(userSingleton.getUserRecipes());
    }
}