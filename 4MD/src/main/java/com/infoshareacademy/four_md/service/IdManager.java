package com.infoshareacademy.four_md.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IdManager {
    private final String filePath;
    public IdManager(String filePath) throws IOException {
        this.filePath = filePath;
        Path path = Path.of(filePath);
        if(!Files.exists(path)){
            Files.writeString(path,"0");
        }
    }
    public int read() throws IOException{
        return Integer.parseInt(Files.readString(Path.of(filePath)));
    }
    public void next() throws IOException{
        Files.writeString(Path.of(filePath),Integer.toString(read()+1));
    }
}