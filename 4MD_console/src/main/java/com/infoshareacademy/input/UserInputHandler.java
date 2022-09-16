package com.infoshareacademy.input;

import com.infoshareacademy.UserSingleton;

public class UserInputHandler {

    private final UserInputScanner userInputScanner;
    private final UserSingleton user;

    private boolean isRunning = true;

    public UserInputHandler(UserSingleton user) {
        this.userInputScanner = UserInputScanner.getInstance();
        this.user = user;
    }

    public void run() {
        while (isRunning) {
            UserInputEnum.printMenu();
            UserInputEnum input = userInputScanner.getUserInputEnum();
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
                default -> {
                    isRunning = false;
                }
            }
        }
    }
}
