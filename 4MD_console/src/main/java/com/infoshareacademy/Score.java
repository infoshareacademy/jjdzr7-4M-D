package com.infoshareacademy;

public class Score {
    private int score;
    private Recipe recipe;

    public Score(int score, Recipe recipe) {
        this.score = score;
        this.recipe = recipe;
    }

    public int getScore() {
        return score;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
