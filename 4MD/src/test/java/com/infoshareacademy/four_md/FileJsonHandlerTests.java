package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.RecipeFileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileJsonHandlerTests {
    private final JsonTestSubject testedManager;
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public FileJsonHandlerTests() throws IOException {
        testedManager = new JsonTestSubject();
        recipes.add(new Recipe(0, "minecraft", new ArrayList<>(), 0, 0, 660, 10, "gra"));
        recipes.add(new Recipe(1, "kawa", List.of("kawa","uśmiech"), 0, 0, 60, 10, "jedzenie"));
        recipes.add(new Recipe(2, "spagetti", new ArrayList<>(), 0, 0, 1000, 10, "Test_food"));
        recipes.add(new Recipe(3, "asdxczefr2efefefwwq", new ArrayList<>(), 0, 0, 200, 10, "Test_food"));
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
            Assertions.assertEquals(recipe.getTypeOfFood(), jsonRecipe.getTypeOfFood());
            Assertions.assertEquals(recipe.getKcal(), jsonRecipe.getKcal());
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
    static class JsonTestSubject extends RecipeFileHandler {


        public JsonTestSubject() throws IOException {
            RECIPES_PATH = "/tmp/" + new Random().nextInt() + "/";
            System.out.println("Test dir is located at: "+RECIPES_PATH);
            Files.createDirectory(Path.of(RECIPES_PATH));
        }

    }
}
