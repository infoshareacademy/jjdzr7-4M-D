package com.infoshareacademy;

import java.util.List;

public class User {
    private String firstName;
    private String secondName;
    private List<Recipe> userRecipes;
    private List<Score> userScores;

    public User(String firstName, String secondName, List<Recipe> userRecipes, List<Score> userScores) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userRecipes = userRecipes;
        this.userScores = userScores;
    }

    public void addRecipeToUserRecipes(Recipe recipe) {
        userRecipes.add(recipe);
    }

    public void deleteRecipeFromUserRecipes(Recipe recipe) {
        userRecipes.remove(recipe);
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

    public List<Recipe> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(List<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public List<Score> getUserScores() {
        return userScores;
    }

    public void setUserScores(List<Score> userScores) {
        this.userScores = userScores;
    }
}
