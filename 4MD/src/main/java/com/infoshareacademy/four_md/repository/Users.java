package com.infoshareacademy.four_md.repository;

import com.infoshareacademy.four_md.models.User;
import com.infoshareacademy.four_md.service.FileHandler;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class Users {
    private final List<User> users;

    public Users() throws IOException {
        this.users = importUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public static List<User> importUsers() throws IOException {
        FileHandler<User> fileHandler = new FileHandler<User>("src/main/resources/users/", User.class);
        return fileHandler.getAll();
    }


}