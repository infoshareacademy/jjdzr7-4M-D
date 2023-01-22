package com.infoshareacademy.four_md.model;

<<<<<<< HEAD
import com.infoshareacademy.four_md.service.interfaces.ObjectWithId;

import java.util.List;

public class User implements ObjectWithId {
=======
import java.util.List;

public class User {
>>>>>>> 34e1cf3713d20f365a332cc4e5bd95699980b505
    private int id;
    private String name;
    private String surname;
    private List<Recipe> listOfRecipes;

    public User(int id, String name, String surname, List<Recipe> listOfRecipes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.listOfRecipes = listOfRecipes;
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