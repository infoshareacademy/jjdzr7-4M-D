package com.infoshareacademy.four_md.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    private int id;
    private String name;
    private String surname;
    private List<Recipe> listOfRecipes = new ArrayList<>();
}