package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.model.Difficulty;
import com.infoshareacademy.four_md.model.DishType;
import com.infoshareacademy.four_md.model.Ratings;
import com.infoshareacademy.four_md.model.Recipe;
import com.infoshareacademy.four_md.service.FileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileJsonHandlerTests {
    private final JsonTestSubject testedManager;
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public FileJsonHandlerTests() throws IOException {
        testedManager = new JsonTestSubject();
        recipes.add(new Recipe(0, "minecraft", new ArrayList<>(), 0, 100, List.of(Ratings.R3), Difficulty.MEDIUM, DishType.MAIN_COURSE));
        recipes.add(new Recipe(1, "kawa", new ArrayList<>(), 0, -5, List.of(Ratings.R3),Difficulty.MEDIUM,DishType.DESSERT));

    }

    @Test
    public void TestWriteback() throws IOException {
        for (Recipe recipe : recipes) {
            testedManager.save(recipe);
        }
        List<Recipe> jsonRecipes = testedManager.getAll();
        Assertions.assertEquals(recipes.size(), jsonRecipes.size());

        for (Recipe recipe : recipes) {
            Recipe jsonRecipe = (Recipe)
                    jsonRecipes.stream().filter(recipe1 -> recipe1.getId() == recipe.getId()).toArray()[0];
            //
            Assertions.assertEquals(recipe.getName(), jsonRecipe.getName());
            Assertions.assertEquals(recipe.getDishType(), jsonRecipe.getDishType());
            Assertions.assertEquals(recipe.getCalories(), jsonRecipe.getCalories());
        }
    }
    @Test
    public void TestRecipeModification() throws IOException {
        testedManager.save(recipes.get(0));
        testedManager.save(recipes.get(1));
        List<Recipe> jsonRecipes = testedManager.getAll();
        Recipe modRecipe = testedManager.get(1);
        //
        Assertions.assertEquals(2, jsonRecipes.size());
        modRecipe.setName("Modified name");
        testedManager.save(modRecipe);
        Recipe updatedRecipe = testedManager.get(1);
        Assertions.assertEquals(modRecipe.getName(),updatedRecipe.getName());

    }
    @Test
    public void TestRecipeRemoval() throws IOException {
        testedManager.save(recipes.get(0));
        testedManager.save(recipes.get(1));

        List<Recipe> jsonRecipes = testedManager.getAll();
        Assertions.assertEquals(2, jsonRecipes.size());
        testedManager.remove(0);

        List<Recipe> updatedJsonRecipes = testedManager.getAll();
        Assertions.assertEquals(1, updatedJsonRecipes.size());
        Assertions.assertEquals(recipes.get(1).getName(),updatedJsonRecipes.get(0).getName());
    }
    static class JsonTestSubject extends FileHandler<Recipe> {


        public JsonTestSubject() throws IOException {
            super("/tmp/" + new Random().nextInt() + "/", Recipe.class);
        }

    }
}
