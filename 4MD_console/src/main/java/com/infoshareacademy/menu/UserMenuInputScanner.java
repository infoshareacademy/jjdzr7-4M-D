package com.infoshareacademy.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

class UserMenuInputScanner {

    private static final int MIN_USER_INPUT = 0;
    private static final int MAX_USER_INPUT = UserMenuOptionsEnum.values().length;
    private static UserMenuInputScanner instance;
    private final Scanner scanner;

    public static UserMenuInputScanner getInstance() {
        if (instance == null) {
            instance = new UserMenuInputScanner();
        }
        return instance;
    }

    private UserMenuInputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public UserMenuOptionsEnum getUserInputEnum() {
        int userInput = readInputFromUser();
        return UserMenuOptionsEnum.values()[userInput];
    }

    private int readInputFromUser() {
        int input = readUserInput();
        while (!isInputCorrect(input)) {
            System.out.println("Wrong input!");
            input = readUserInput();
        }
        return input;
    }

    private boolean isInputCorrect(int n) {
        boolean isBiggerThanMin = n >= MIN_USER_INPUT;
        boolean isSmallerThanMax = n <= MAX_USER_INPUT;
        return isBiggerThanMin && isSmallerThanMax;
    }

    private int readUserInput() {
        int result = -1;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
        }
        return result;
    }
}
