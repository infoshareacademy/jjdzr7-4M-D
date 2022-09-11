package com.infoshareacademy.recipeUiTools;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    private final int[] tableMaxLenghts;
    private final List<List<String>> Table = new ArrayList<>();
    private final int columns;

    public TableBuilder(int columns) {

        this.columns = columns;
        this.tableMaxLenghts = new int[columns];
    }

    public TableBuilder AddRow(List<String> row) {
        if (row.size() != columns) throw new RuntimeException("Row must contain EXACTLY " + columns + " elements");
        Table.add(row);
        return this;
    }

    public String build() {
        for (int i = 0; i < columns; i++) {
            tableMaxLenghts[i] = getLongestLenghtForRow(i);
        }
        StringBuilder outputBuilder = new StringBuilder();
        for (List<String> row : Table) {
            for (int i = 0; i < tableMaxLenghts.length; i++) {
                outputBuilder.append(spaceOutString(row.get(i), tableMaxLenghts[i]))
                        .append(" ");
            }
            outputBuilder.append("\n");
        }
        return outputBuilder.toString();
    }

    private String spaceOutString(String text, int exceptedLenght) {
        int spacesRequired = exceptedLenght - text.length();
        return text + " ".repeat(spacesRequired);
    }

    private int getLongestLenghtForRow(int rowIndex) {
        var strings = Table.stream().map(row -> row.get(rowIndex)).toArray();
        int recipeNameMaxLenght = 0;
        for (Object x : strings) {
            String xStr = x.toString();
            recipeNameMaxLenght = Math.max(recipeNameMaxLenght, xStr.length());
        }
        return recipeNameMaxLenght;
    }
}
