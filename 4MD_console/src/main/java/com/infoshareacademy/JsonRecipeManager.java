package com.infoshareacademy;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonRecipeManager {
    protected String RECIPES_PATH = "./recipes/";
    private final Gson gson = new Gson();

    public JsonRecipeManager() throws IOException {
        try{

            Files.createDirectory(Path.of(RECIPES_PATH));
        }
        catch (FileAlreadyExistsException x){
            // Great, who asked?
        }

    }
    public void save(Recipe recipe) throws IOException {
        String value = gson.toJson(recipe);
        Files.writeString(Path.of(RECIPES_PATH+recipe.getId()+".json"),value);
    }
    public void remove(int recipeId) throws IOException {
        Files.delete(Path.of(RECIPES_PATH+recipeId+".json"));
    }
    public Recipe loadJsonFile(int recipeId) throws IOException {
        String file = Files.readString(Path.of(RECIPES_PATH+recipeId+".json"));
        return gson.fromJson(file, Recipe.class);
    }
    //Pls load this to cache
    public List<Recipe> loadAll() throws IOException {
        List<Recipe> out = new ArrayList<>();
        // I don't care about try-with-resources
        //noinspection resource
        Object[] files = Files.list(Path.of(RECIPES_PATH)).toArray();

        for (Object file : files) {
            Path path = (Path) file;
            String filename = path.getFileName().toString();
            if(filename.endsWith(".json")){
                String id = filename.split("\\.")[0];
                out.add(loadJsonFile(Integer.parseInt(id)));
            }
        }
        return out;
    }
}
