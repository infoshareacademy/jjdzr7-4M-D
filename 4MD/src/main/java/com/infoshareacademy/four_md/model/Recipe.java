package com.infoshareacademy.four_md.model;

import com.infoshareacademy.four_md.service.interfaces.ObjectWithId;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements ObjectWithId {
    private int id;
    private String name;
    private List<Ingredients> ingredientsList;
    private int estimatedCookingTime;
    private int calories;
    private double cost;
    private List<Integer> ratings;
    private List<Ratings> ratingsList;
    private Difficulty difficulty;
    private DishType dishType;

    public Recipe(int id, String name, List<Ingredients> ingredientsList, int estimatedCookingTime, int calories, List<Ratings> ratingsList, Difficulty difficulty, DishType dishType) {
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.estimatedCookingTime = estimatedCookingTime;
        this.calories = calories;
        this.cost = costCalculator();
        this.ratingsList = ratingsList;
        this.difficulty = difficulty;
        this.dishType = dishType;
    }
    public Recipe() {
        //! important for spring deserialization 
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
        double sum = ratingsList.stream().mapToDouble(Ratings::getNumVal).sum();
        return sum / (ratingsList.size());
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
