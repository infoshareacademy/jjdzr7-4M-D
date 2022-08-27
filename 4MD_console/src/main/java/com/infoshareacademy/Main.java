package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        List<Recipe> list = new ArrayList<>();
        List<Score> list2 = new ArrayList<>();
        Recipe recipe = new Recipe();
        Recipe recipe2 = new Recipe();
        Recipe recipe3 = new Recipe();
        User user = new User("Robert", "Maklowicz", list, list2);
        System.out.println(user.getFirstName() + user.getSecondName() + user.getUserRecipes() +  user.getUserScores());
        UserSingleton userSingleton = UserSingleton.getInstance("Robert", "Maklowicz", list, list2);
        UserSingleton userSingleton1 = UserSingleton.getInstance("Mietek", "Maklowicz", list, list2);
        System.out.println(userSingleton.getFirstName() + userSingleton.getSecondName() + userSingleton.getUserRecipes() + userSingleton.getUserScores());
        user.addRecipeToUserRecipes(recipe);
        user.addRecipeToUserRecipes(recipe2);
        user.addRecipeToUserRecipes(recipe3);
        user.deleteRecipeFromUserRecipes(recipe2);
        System.out.println(user.getUserRecipes());
        UserRecipeManager userRecipeManager = new UserRecipeManager(user.getUserRecipes());
        System.out.println(user.getUserRecipes());
        userRecipeManager.addRecipeToUserRecipes(recipe3);
        System.out.println(user.getUserRecipes());
    }
}
