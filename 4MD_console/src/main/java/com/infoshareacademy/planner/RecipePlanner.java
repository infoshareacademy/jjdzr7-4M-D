package com.infoshareacademy.planner;

import com.infoshareacademy.Recipe;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RecipePlanner {
    private final Map<LocalDate, Recipe> planner;

    public RecipePlanner() {
        this.planner = new HashMap<>();
    }


}
