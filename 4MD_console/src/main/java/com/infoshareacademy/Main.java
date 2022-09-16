package com.infoshareacademy;

import com.infoshareacademy.menu.UserInputHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserSingleton user = UserSingleton.getInstance("Jan", "Kowalski", List.of(), List.of());
        UserInputHandler userInputHandler = new UserInputHandler(user);
        userInputHandler.run();
    }
}