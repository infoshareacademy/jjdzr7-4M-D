package com.infoshareacademy.input;

import java.util.InputMismatchException;
import java.util.Scanner;

class UserInputScanner {

    private static final int MIN_USER_INPUT = 0;
    private static final int MAX_USER_INPUT = UserInputEnum.values().length;
    private static UserInputScanner instance;
    private final Scanner scanner;

    public static UserInputScanner getInstance() {
        if (instance == null) {
            instance = new UserInputScanner();
        }
        return instance;
    }

    private UserInputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public UserInputEnum getUserInputEnum() {
        int userInput = readInputFromUser();
        return UserInputEnum.values()[userInput];
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
