package com.infoshareacademy;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<String> ListOfIngrediens;
    private int time;
    private String difficulty;
    private int kcal;
    private int cost;
    public Recipe(String name,int kcal){
        setName(name);
        setKcal(kcal);
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

    public List<String> getListOfIngrediens() {
        return ListOfIngrediens;
    }

    public void setListOfIngrediens(List<String> listOfIngrediens) {
        ListOfIngrediens = listOfIngrediens;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
