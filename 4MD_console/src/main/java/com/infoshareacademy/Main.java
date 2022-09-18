package com.infoshareacademy;

import com.infoshareacademy.menu.UserMenuInputHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RecipesProvider.getRecipes();
        UserSingleton user = UserSingleton.getInstance("Jan", "Kowalski", List.of(), List.of());
        UserMenuInputHandler userMenuInputHandler = new UserMenuInputHandler(user);
        userMenuInputHandler.run();
    }
}