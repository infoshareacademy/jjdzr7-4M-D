package com.infoshareacademy.four_md.service;

import com.google.gson.Gson;
import com.infoshareacademy.four_md.models.Recipe;
import com.infoshareacademy.four_md.service.interfaces.RecipeProvider;
import org.springframework.stereotype.Component;

import java.awt.Window.Type;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler<T> {
    private String databasePath;
    private final Gson gson = new Gson();
    private Class<T> clazz;

    public FileHandler(String databasePath,Class<T> clazz) throws IOException {
        this.databasePath = databasePath;
        this.clazz = clazz;
        try{

            Files.createDirectory(Path.of(databasePath));
        }
        catch (FileAlreadyExistsException x){
            // Great, who asked?
        }
    }
    public void save(T obj, int Id) throws IOException {
        String value = gson.toJson(obj);
        Files.writeString(Path.of(databasePath+Id+".json"),value);
    }
    public void remove(int Id) throws IOException {
        Files.delete(Path.of(databasePath+Id+".json"));
    }
    public T get(int Id) throws IOException {
        String file = Files.readString(Path.of(databasePath+Id+".json"));
        return gson.fromJson(file,clazz);
    }
    //Pls load this to cache
    public List<T> getAll() throws IOException {
        List<T> out = new ArrayList<>();
        // I don't care about try-with-resources
        //noinspection resource
        Object[] files = Files.list(Path.of(databasePath)).toArray();

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