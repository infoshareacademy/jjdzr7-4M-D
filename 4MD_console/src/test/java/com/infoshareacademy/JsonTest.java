package com.infoshareacademy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JsonTest {
    private final JsonTestSubject testedManager;
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public JsonTest() throws IOException {
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
        List<Recipe> jsonRecipes = testedManager.loadAll();
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

    class JsonTestSubject extends JsonRecipeManager {


        public JsonTestSubject() throws IOException {
            RECIPES_PATH = "/tmp/" + new Random().nextInt() + "/";
            System.out.println("Test dir is located at: "+RECIPES_PATH);
            Files.createDirectory(Path.of(RECIPES_PATH));
        }
    }
}
