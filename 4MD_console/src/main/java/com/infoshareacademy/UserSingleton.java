package com.infoshareacademy;

import java.util.List;

public class UserSingleton {

    private String firstName;
    private String secondName;
    private List<Recipe> userRecipes;

    private List<Score> userScores;
    private static volatile UserSingleton instance;

    public UserSingleton(String firstName, String secondName, List<Recipe> listOfRecipes, List<Score> listOfScores) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userRecipes = listOfRecipes;
        this.userScores = listOfScores;
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

    public List<Recipe> getUserRecipes() {
        return userRecipes;
    }

    public List<Score> getUserScores() {
        return userScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setUserRecipes(List<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public void setUserScores(List<Score> userScores) {
        this.userScores = userScores;
    }
}

