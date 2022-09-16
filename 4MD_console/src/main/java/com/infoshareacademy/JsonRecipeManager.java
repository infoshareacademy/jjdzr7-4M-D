package com.infoshareacademy;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonRecipeManager {
    protected String RECIPES_PATH = "./recipes/";

    public JsonRecipeManager() throws IOException {
        try{

            Files.createDirectory(Path.of(RECIPES_PATH));
        }
        catch (FileAlreadyExistsException x){
            // Great, who asked?
        }

    }
    public void save(Recipe recipe) throws IOException {
        String value = JSONObject.valueToString(recipe);
        Files.writeString(Path.of(RECIPES_PATH+recipe.getId()+".json"),value);
    }
    public Recipe loadJsonFile(int recipeId) throws IOException {
        String file = Files.readString(Path.of(RECIPES_PATH+recipeId+".json"));
        return (Recipe) JSONObject.stringToValue(file);
    }
    //Pls load this to cache
    public List<Recipe> loadAll() throws IOException {
        List<Recipe> out = new ArrayList<>();
        Stream<Path> files = Files.list(Path.of(RECIPES_PATH));
        for (Object file : files.filter(path -> path.getFileName().endsWith(".json")).toArray()) {
            Path path = (Path) file;
            String id = path.getFileName().toString().split("\\.")[0];
            out.add(loadJsonFile(Integer.getInteger(id)));
        }
        return out;
    }
}
