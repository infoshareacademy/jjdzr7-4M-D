package com.infoshareacademy;

import java.util.List;

public class User {
    private String firstName;
    private String secondName;
    private List<Recipe> listOfRecipes;
    private List<Score> listOfScore;

    public User(String firstName, String secondName, List<Recipe> listOfRecipes, List<Score> listOfScore) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.listOfRecipes = listOfRecipes;
        this.listOfScore = listOfScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    public void setListOfRecipes(List<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    public List<Score> getListOfScore() {
        return listOfScore;
    }

    public void setListOfScore(List<Score> listOfScore) {
        this.listOfScore = listOfScore;
    }
}
