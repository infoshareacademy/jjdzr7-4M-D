package com.infoshareacademy.recipeUiTools;

import com.infoshareacademy.Recipe;

import java.util.List;

public class RecipeDisplay {
    private final Recipe recipe;

    public RecipeDisplay(Recipe recipe){

        this.recipe = recipe;

    }
    public String generateSummary(){
        StringBuilder stringBuilder = new StringBuilder();
        TableBuilder tableBuilder = new TableBuilder(2);
        stringBuilder.append(tableBuilder
                .AddRow(List.of("Nazwa:",recipe.getName()))
                .AddRow(List.of("Kcal:", recipe.getKcal()+" kcal."))
                .AddRow(List.of("Koszt:", recipe.getCost()+" zł."))
                .AddRow(List.of("Rodzaj:",recipe.getTypeOfFood()))
                .AddRow(List.of("Czas wykonania:", recipe.getTime()+" minut"))
                .AddRow(List.of("Poziom trudności:",recipe.getDifficulty()+" pkt."))
                .AddRow(List.of("Składniki:",""))
                .build());
        for (String ingredient:recipe.getListOfIngredients()) {
            stringBuilder
                    .append("   * ")
                    .append(ingredient)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
