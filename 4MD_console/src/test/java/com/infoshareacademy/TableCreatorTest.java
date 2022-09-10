package com.infoshareacademy;

import com.infoshareacademy.recipeUiTools.TableBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableCreatorTest{
    @Test
    public void testTableFormat(){
        TableBuilder testedCreator = new TableBuilder(2);
        testedCreator.AddRow(new String[]{"name:","InfoShare"});
        testedCreator.AddRow(new String[]{"age:","15"});
        testedCreator.AddRow(new String[]{"x:","xyz"});
        StringBuilder builder = new StringBuilder();
        //
        builder .append("name: InfoShare \n")
                .append("age:  15        \n")
                .append("x:    xyz       \n");
        String output = testedCreator.build();
        String excepted_output = builder.toString();
        //
        Assertions.assertEquals(excepted_output,output);
    }
}
