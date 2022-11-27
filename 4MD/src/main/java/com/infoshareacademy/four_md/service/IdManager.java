package com.infoshareacademy.four_md.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IdManager {
    private String filePath;
    public IdManager(String filePath) throws IOException {
        this.filePath = filePath;
        if(!Files.exists(Path.of(filePath))){
            Files.writeString(Path.of(filePath),"0");
        }
    }
    public int read() throws IOException{
        return Integer.parseInt(Files.readString(Path.of(filePath)));
    }
    public void next() throws IOException{
        Files.writeString(Path.of(filePath),Integer.toString(read()+1));
    }
}