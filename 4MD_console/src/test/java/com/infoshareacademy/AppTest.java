package com.infoshareacademy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    void testInputSelection(){
        Scanner testScanner = new Scanner("kawa\n");
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(0,"minecraft",new ArrayList<>(),0,0,660,10,"gra"));
        recipes.add(new Recipe(1,"kawa",new ArrayList<>(),0,0,60,10,"jedzenie"));
        recipes.add(new Recipe(2,"spagetti",new ArrayList<>(),0,0,1000,10,"Test_food"));
        recipes.add(new Recipe(3,"asdxczefr2efefefwwq",new ArrayList<>(),0,0,200,10,"Test_food"));
        RecipePicker picker = new RecipePicker(recipes);
        picker.setInput(testScanner);
        //
        Recipe recipe = picker.activate();
        Assertions.assertSame(recipe, recipes.get(1));
    }
}
