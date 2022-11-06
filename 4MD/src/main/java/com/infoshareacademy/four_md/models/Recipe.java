package com.infoshareacademy.four_md.models;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<String> listOfIngredients;
    private double time;
    private int difficulty;
    private int kcal;
    private double cost;
    private String typeOfFood;

    public Recipe(int id, String name, List<String> listOfIngredients, double time, int difficulty, int kcal, double cost, String typeOfFood) {
        this.id = id;
        this.name = name;
        this.listOfIngredients = listOfIngredients;
        this.time = time;
        this.difficulty = difficulty;
        this.kcal = kcal;
        this.cost = cost;
        this.typeOfFood = typeOfFood;
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

    public List<String> getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(List<String> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }
}
