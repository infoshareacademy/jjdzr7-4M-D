package com.infoshareacademy.four_md.service;

import com.google.gson.Gson;
import com.infoshareacademy.four_md.model.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class UserFileHandler implements UserProvider {

    protected String USERS_PATH = "./users/";
    private final Gson gson = new Gson();

    public UserFileHandler() throws IOException {
        try{

            Files.createDirectory(Path.of(USERS_PATH));
        }
        catch (FileAlreadyExistsException x){
            //Żywcem skopiowane od Mikołaja
        }

    }

    @Override
    public User get(int userId) throws IOException {
        String file = Files.readString(Path.of(USERS_PATH+userId+".json"));
        return gson.fromJson(file, User.class);
    }

    @Override
    public void save(User user) throws IOException {
        String value = gson.toJson(user);
        Files.writeString(Path.of(USERS_PATH+user.getId()+".json"),value);
    }

    @Override
    public void remove(int userId) throws IOException {
        Files.delete(Path.of(USERS_PATH+userId+".json"));
    }
}
