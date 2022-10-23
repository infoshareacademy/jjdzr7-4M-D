package com.infoshareacademy.four_md.domain;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<Ingredients> ingredientsList;
    private int estimatedCookingTime;
    private int calories;
    private final double cost;
    private double rating;
    private Difficulty difficulty;
    private DishType dishType;

    public Recipe(int id, String name, List<Ingredients> ingredientsList, int estimatedCookingTime, int calories, double rating, Difficulty difficulty, DishType dishType) {
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.estimatedCookingTime = estimatedCookingTime;
        this.calories = calories;
        this.cost = costCalculator();
        this.rating = rating;
        this.difficulty = difficulty;
        this.dishType = dishType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public int getEstimatedCookingTime() {
        return estimatedCookingTime;
    }

    public void setEstimatedCookingTime(int estimatedCookingTime) {
        this.estimatedCookingTime = estimatedCookingTime;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCost() {
        return cost;
    }

    private double costCalculator() {
        return ingredientsList.stream().mapToDouble(Ingredients::getPrice).sum();
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredientsList=" + ingredientsList +
                ", estimatedCookingTime=" + estimatedCookingTime +
                ", calories=" + calories + " kcal" +
                ", cost=" + cost + " zł" +
                ", rating=" + rating +
                ", difficulty=" + difficulty +
                ", dishType=" + dishType +
                '}';
    }

}
