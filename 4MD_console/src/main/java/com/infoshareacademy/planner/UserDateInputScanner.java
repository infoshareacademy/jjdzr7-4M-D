package com.infoshareacademy.planner;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDateInputScanner {

    private static UserDateInputScanner instance;
    private final Scanner scanner;

    public static UserDateInputScanner getInstance() {
        if (instance == null) {
            instance = new UserDateInputScanner();
        }
        return instance;
    }

    public UserDateInputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public LocalDate getLocalDate() {
        String userInput = readUserInput();
        while (!isInputCorrect(userInput)) {
            userInput = readUserInput();
        }
        return LocalDate.parse(userInput);
    }

    private boolean isInputCorrect(String userInput) {
        boolean isCorrect = false;
        try {
            System.out.println("Date format must be yyyy-MM-dd");
            LocalDate.parse(userInput);
            isCorrect = true;
        } catch (DateTimeParseException e) {
            System.out.println("Wrong date format");
        }
        return isCorrect;
    }

    private String readUserInput() {
        String result = null;
        try {
            result = scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.next();
        }
        return result;
    }
}
