package com.infoshareacademy.four_md.service;

import com.google.gson.Gson;
import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.interfaces.FileHandler;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileJsonHandler implements FileHandler {
    protected String RECIPES_PATH = "./recipes/";
    private final Gson gson = new Gson();

    public FileJsonHandler() throws IOException {
        try{

            Files.createDirectory(Path.of(RECIPES_PATH));
        }
        catch (FileAlreadyExistsException x){
            // Great, who asked?
        }

    }
    @Override
    public void save(Recipe recipe) throws IOException {
        String value = gson.toJson(recipe);
        Files.writeString(Path.of(RECIPES_PATH+recipe.getId()+".json"),value);
    }
    @Override
    public void remove(int recipeId) throws IOException {
        Files.delete(Path.of(RECIPES_PATH+recipeId+".json"));
    }
    @Override
    public Recipe get(int recipeId) throws IOException {
        String file = Files.readString(Path.of(RECIPES_PATH+recipeId+".json"));
        return gson.fromJson(file, Recipe.class);
    }
    //Pls load this to cache
    @Override
    public List<Recipe> getAll() throws IOException {
        List<Recipe> out = new ArrayList<>();
        // I don't care about try-with-resources
        //noinspection resource
        Object[] files = Files.list(Path.of(RECIPES_PATH)).toArray();

        for (Object file : files) {
            Path path = (Path) file;
            String filename = path.getFileName().toString();
            if(filename.endsWith(".json")){
                String id = filename.split("\\.")[0];
                out.add(get(Integer.parseInt(id)));
            }
        }
        return out;
    }
}
