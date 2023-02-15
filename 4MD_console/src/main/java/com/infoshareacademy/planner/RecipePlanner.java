package com.infoshareacademy.planner;

import com.infoshareacademy.Recipe;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RecipePlanner {
    private final Map<LocalDate, Recipe> planner;
    private final UserDateInputScanner userDateInputScanner;

    public RecipePlanner() {
        this.planner = new HashMap<>();
        this.userDateInputScanner = UserDateInputScanner.getInstance();
    }

    public void addToPlanner() {
        System.out.println("Enter the date when You want to save the dish");
        LocalDate date = userDateInputScanner.getLocalDate();
        System.out.println("Enter id of recipe You want to add");
        Recipe recipe = null; // here we need mechanism to get recipe by id
        planner.put(date, recipe);
    }

    public void removeFromPlanner() {
        System.out.println("Enter the date when You want to remove the dish");
        LocalDate date = userDateInputScanner.getLocalDate();
        planner.remove(date);
    }

    public void showPlanner() {
        planner.forEach((date, recipe) -> System.out.println(date + " " + recipe.getName()));
    }
}
