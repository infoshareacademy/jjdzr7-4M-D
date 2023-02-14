package com.infoshareacademy.four_md.model.entitiy;

import com.infoshareacademy.four_md.model.dto.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchEngineEntity {
    private Recipe recipe;
    private String name;
    private int calories;
    private double price;

}