package com.infoshareacademy.four_md.model;

public class User {
    private int userId;
    private String name;
    private String username;
    private String email;
    private String city;

    public User(int userId, String name, String username, String email, String city) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setSurname(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
