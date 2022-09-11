package com.infoshareacademy.recipeUiTools;

import com.infoshareacademy.Recipe;

public class RecipeDisplay {
    private final Recipe recipe;

    public RecipeDisplay(Recipe recipe){

        this.recipe = recipe;

    }
    public String generateSummary(){
        StringBuilder stringBuilder = new StringBuilder();
        TableBuilder tableBuilder = new TableBuilder(2);
        stringBuilder.append(tableBuilder
                .AddRow(new String[]{"Nazwa:",recipe.getName()})
                .AddRow(new String[]{"Kcal:", recipe.getKcal()+" kcal."})
                .AddRow(new String[]{"Koszt:", recipe.getCost()+" zł."})
                .AddRow(new String[]{"Rodzaj:",recipe.getTypeOfFood()})
                .AddRow(new String[]{"Czas wykonania:", recipe.getTime()+" minut"})
                .AddRow(new String[]{"Poziom trudności:",recipe.getDifficulty()+" pkt."})
                .AddRow(new String[]{"Składniki:",""})
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
