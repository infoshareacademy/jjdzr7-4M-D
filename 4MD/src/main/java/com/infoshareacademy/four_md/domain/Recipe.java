package com.infoshareacademy.four_md.domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<Ingredients> ingredientsList;
    private int estimatedCookingTime;
    private int calories;
    private final double cost;
    private List<Integer> ratings;
    private Difficulty difficulty;
    private DishType dishType;

    public Recipe(int id, String name, List<Ingredients> ingredientsList, int estimatedCookingTime, int calories, List<Integer> ratings, Difficulty difficulty, DishType dishType) {
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.estimatedCookingTime = estimatedCookingTime;
        this.calories = calories;
        this.cost = costCalculator();
        checkPoints(ratings);
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

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        checkPoints(ratings);
        this.ratings = ratings;
    }

    private void checkPoints(List<Integer> ratings) {
        try {
            for (Integer el : ratings) {
                if (!el.equals(0) && !el.equals(1) && !el.equals(2) && !el.equals(3) && !el.equals(4) && !el.equals(5)) {
                    System.out.println("Incorrect rating value in constructor or setter: " + el);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.ratings = ratings;


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
                ", rating=" + ratings +
                ", difficulty=" + difficulty +
                ", dishType=" + dishType +
                '}';
    }

    private double averageRating() {
        double sum = ratings.stream().mapToDouble(n -> n).sum();
        return sum / (ratings.size());
    }

    public Integer roundAverageRating() {
        return Math.toIntExact(Math.round(averageRating()));
    }

    public List<Ingredients> ingredientListsCopy() {
        List<Ingredients> list = new ArrayList<>();
        for (Ingredients el : ingredientsList) {
            Ingredients ingredients = new Ingredients();
            ingredients.copyIngredients(el);
            list.add(ingredients);
        }
        return list;
    }

    public List<Ingredients> ingredientsListByPortion(int numberOfPortions) {
        List<Ingredients> list = new ArrayList<>(ingredientListsCopy());
        list.forEach(n -> n.setQuantity(n.getQuantity() * numberOfPortions));
        list.forEach(n -> n.setPrice(n.getPrice() * numberOfPortions));
        return list;
    }

}
