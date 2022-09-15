package com.infoshareacademy;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonRecipeManager extends ArrayList<Recipe> {
    private final Path PATH = Path.of("./recipes");

    public JsonRecipeManager() throws IOException {
        Files.createDirectory(PATH);

    }
    public void save(Recipe recipe){
        String value = JSONObject.valueToString(recipe);
    }
    private void loadJsonFile(String path){

    }
    public List<Recipe> loadAll() throws IOException {
        Stream<Path> files = Files.list(PATH);
        for (Object file : files.filter(path -> path.getFileName().endsWith(".json")).toArray()) {
            Path path = (Path) file;

        }
    }
}
