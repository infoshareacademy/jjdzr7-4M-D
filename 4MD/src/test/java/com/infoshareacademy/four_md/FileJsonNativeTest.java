package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.model.Difficulty;
import com.infoshareacademy.four_md.model.DishType;
import com.infoshareacademy.four_md.model.Ratings;
import com.infoshareacademy.four_md.model.Recipe;
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
        recipes.add(new Recipe(0, "minecraft", new ArrayList<>(), 0, 100, List.of(Ratings.R3),Difficulty.MEDIUM,DishType.MAIN_COURSE));
        recipes.add(new Recipe(1, "kawa", new ArrayList<>(), 0, -5, List.of(Ratings.R3),Difficulty.MEDIUM,DishType.DESSERT));
        recipes.add(new Recipe(2, "spagetti", new ArrayList<>(), 0, 0, List.of(Ratings.R3),Difficulty.HARD,DishType.SOUP));
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
            Assertions.assertEquals(recipe.getDishType(), jsonRecipe.getDishType());
            Assertions.assertEquals(recipe.getCalories(), jsonRecipe.getCalories());
        }
    }
}
