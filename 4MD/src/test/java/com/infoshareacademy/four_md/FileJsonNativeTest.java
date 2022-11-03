package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.RecipeFileHandler;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileJsonNativeTest {
    @Test
    public void TestWriteback() throws IOException {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(0, "minecraft", new ArrayList<>(), 0, 0, 660, 10, "gra"));
        recipes.add(new Recipe(1, "kawa", List.of("kawa","uśmiech"), 0, 0, 60, 10, "jedzenie"));
        recipes.add(new Recipe(2, "spagetti", new ArrayList<>(), 0, 0, 1000, 10, "Test_food"));
        recipes.add(new Recipe(3, "asdxczefr2efefefwwq", new ArrayList<>(), 0, 0, 200, 10, "Test_food"));
        RecipeProvider db = new RecipeFileHandler();

        for (Recipe recipe : recipes) {
            db.save(recipe);
        }
        List<Recipe> jsonRecipes = db.getAll();
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
}
