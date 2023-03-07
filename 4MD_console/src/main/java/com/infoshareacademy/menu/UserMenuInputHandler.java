package com.infoshareacademy.menu;

import com.infoshareacademy.UserSingleton;

public class UserMenuInputHandler {

    private final UserMenuInputScanner userMenuInputScanner;
    private final UserSingleton user;

    private boolean isRunning = true;

    public UserMenuInputHandler(UserSingleton user) {
        this.userMenuInputScanner = UserMenuInputScanner.getInstance();
        this.user = user;
    }

    public void run() {
        while (isRunning) {
            UserMenuOptionsEnum.printMenu();
            UserMenuOptionsEnum input = userMenuInputScanner.getUserInputEnum();
            switch (input) {
                case EXIT -> {
                    System.out.println("EXIT");
                    isRunning = false;
                }
                case ADD_RECIPE -> {
                    System.out.println("ADD_RECIPE");
                }
                case EDIT_RECIPE -> {
                    System.out.println("EDIT_RECIPE");
                }
                case REMOVE_RECIPE -> {
                    System.out.println("REMOVE_RECIPE");
                }
                case SEARCH_RECIPE -> {
                    System.out.println("SEARCH_RECIPE");
                }
                case ADD_RECIPE_TO_PLANNER -> {
                    System.out.println("ADD_RECIPE_TO_PLANNER");
                }
                case REMOVE_RECIPE_FROM_PLANNER -> {
                    System.out.println("REMOVE_RECIPE_FROM_PLANNER");
                }
                case SHOW_PLANNER -> {
                    System.out.println("SHOW_PLANNER");
                }
                default -> {
                    isRunning = false;
                }
            }
        }
    }
}
