package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        List<String> list = new ArrayList<>();
        User user = new User("Robert", "Maklowicz", list, list);
        System.out.println(user.getFirstName() + user.getSecondName() + user.getListOfRecipes() +  user.getListOfScore());
        UserSingleton userSingleton = UserSingleton.getInstance("Robert", "Maklowicz", list, list);
        UserSingleton userSingleton1 = UserSingleton.getInstance("Mietek", "Maklowicz", list, list);
        System.out.println(userSingleton.getFirstName() + userSingleton.getSecondName() + userSingleton.getListOfRecipes() + userSingleton.getListOfScore());
    }
}
