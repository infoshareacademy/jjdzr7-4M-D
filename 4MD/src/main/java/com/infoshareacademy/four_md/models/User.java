package com.infoshareacademy.four_md.models;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String surname;
    private List<Recipe> listOfRecipes;

    public User(String id, String name, String surname, List<Recipe> listOfRecipes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.listOfRecipes = listOfRecipes;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    public void addRecipe(Recipe recipe) {
        getListOfRecipes().add(recipe);
    }

    public void deleteRecipe(int i) {
        getListOfRecipes().remove(i);
    }

    public void setListOfRecipes(List<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
}