package com.infoshareacademy.four_md.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private List<Recipe> listOfRecipes = new ArrayList<>();
}