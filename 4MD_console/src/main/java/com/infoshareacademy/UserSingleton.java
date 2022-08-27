package com.infoshareacademy;

import java.util.List;

public class UserSingleton {

    private String firstName;
    private String secondName;
    private List<Recipe> listOfRecipes;

    private List<Score> listOfScore;
    private static volatile UserSingleton instance;

    public UserSingleton(String firstName, String secondName, List<Recipe> listOfRecipes, List<Score> listOfScores) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.listOfRecipes = listOfRecipes;
        this.listOfScore = listOfScores;
    }

    public static UserSingleton getInstance(String firstName, String secondName, List<Recipe> listOfRecipes, List<Score> listOfScores) {
        UserSingleton result = instance;
        if (result == null) {
            synchronized (UserSingleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new UserSingleton(firstName, secondName, listOfRecipes, listOfScores);
                }
            }
        }
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    public List<Score> getListOfScore() {
        return listOfScore;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setListOfRecipes(List<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    public void setListOfScore(List<Score> listOfScore) {
        this.listOfScore = listOfScore;
    }
}

