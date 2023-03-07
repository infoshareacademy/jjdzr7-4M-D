package com.infoshareacademy;

import com.infoshareacademy.recipeUiTools.RecipeDisplay;
import com.infoshareacademy.recipeUiTools.RecipePicker;
import com.infoshareacademy.recipeUiTools.TableBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableCreatorTest {
    @Test
    public void testTableFormat() {
        TableBuilder testedCreator = new TableBuilder(2);
        testedCreator.AddRow(new String[]{"name:", "InfoShare"})
                .AddRow(new String[]{"age:", "15"})
                .AddRow(new String[]{"x:", "xyz"});
        //
        String excepted_output = "name: InfoShare \n" +
                "age:  15        \n" +
                "x:    xyz       \n";
        String output = testedCreator.build();
        //
        Assertions.assertEquals(excepted_output, output);
    }

    @Test
    public void testIncorrectTableInsertion() {
        TableBuilder testedCreator = new TableBuilder(2);
        testedCreator.AddRow(new String[]{"name:", "InfoShare"});
        Assertions.assertThrows(RuntimeException.class,
                () -> testedCreator.AddRow(new String[]{"age:", "15", "xd"}));

    }

    @Test
    public void TestRecipeFormat() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("kawa 500ml");
        ingredients.add("lód 20g");
        ingredients.add("ręce 2 szt.");
        Recipe recipe = new Recipe(1, "kawuśia", ingredients, 100, 5, 250, 300, "Napoje");
        RecipeDisplay recipeDisplay = new RecipeDisplay(recipe);
        //
        System.out.print(recipeDisplay.generateSummary());
    }

    @Test
    void testInputSelection() {
        Scanner testScanner = new Scanner("kawa\n");
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(0, "minecraft", new ArrayList<>(), 0, 0, 660, 10, "gra"));
        recipes.add(new Recipe(1, "kawa", new ArrayList<>(), 0, 0, 60, 10, "jedzenie"));
        recipes.add(new Recipe(2, "spagetti", new ArrayList<>(), 0, 0, 1000, 10, "Test_food"));
        recipes.add(new Recipe(3, "asdxczefr2efefefwwq", new ArrayList<>(), 0, 0, 200, 10, "Test_food"));
        RecipePicker picker = new RecipePicker(recipes);
        picker.setInput(testScanner);
        //
        Recipe recipe = picker.activate();
        Assertions.assertSame(recipe, recipes.get(1));
    }
}
