package com.infoshareacademy;

import java.util.List;

public class User {
    private String firstName;
    private String secondName;
    private List<String> listOfRecipes;
    private List<String> listOfScore;

    public User(String firstName, String secondName, List<String> listOfRecipes, List<String> listOfScore) {
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

    public List<String> getListOfRecipes() {
        return listOfRecipes;
    }

    public void setListOfRecipes(List<String> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    public List<String> getListOfScore() {
        return listOfScore;
    }

    public void setListOfScore(List<String> listOfScore) {
        this.listOfScore = listOfScore;
    }
}
