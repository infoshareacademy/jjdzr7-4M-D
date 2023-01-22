package com.infoshareacademy.four_md.model;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private Recipe recipe;
    private String name;
    private int calMin;
    private int calMax;
    private double priceMin;
    private double priceMax;

    public SearchEngine(Recipe recipe, String name, int calMin, int calMax, double priceMin, double priceMax) {
        this.recipe = recipe;
        this.name = name;
        this.calMin = calMin;
        this.calMax = calMax;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
    }

    public SearchEngine() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalMin() {
        return calMin;
    }

    public void setCalMin(int calMin) {
        this.calMin = calMin;
    }

    public int getCalMax() {
        return calMax;
    }

    public void setCalMax(int calMax) {
        this.calMax = calMax;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }

    public double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(double priceMax) {
        this.priceMax = priceMax;
    }

    public List<String> searchByCalories() {
        List<String> listCalories = new ArrayList<>();
        for (int i = 0; i ;i++)
        if (recipe.getCalories() > getCalMin() && recipe.getCalories() < getCalMax())
            listCalories.add(getRecipe().getName());
        return listCalories;
    }

    public List<String> searchByName () {
        List<String> listNames = new ArrayList<>();
        if (recipe.getName().equals(getName())) {
            listNames.add(getRecipe().getName());
        }
        return listNames;
    }

    public List<String> searchByPrice() {
        List<String> listPrice = new ArrayList<>();
        if (recipe.getCost() > getPriceMin() && recipe.getCost() < getPriceMax())
            listPrice.add(getRecipe().getName());
        return listPrice;
    }
}
