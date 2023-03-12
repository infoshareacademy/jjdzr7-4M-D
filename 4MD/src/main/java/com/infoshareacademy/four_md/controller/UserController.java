package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class UserController {

    private final UserProvider userProvider;

    @GetMapping("/{id}")
   public User getUser(@PathVariable int id) throws IOException{
           return userProvider.get(id);
    }
    @PostMapping("save")
    public void addUser(User user) throws IOException{
        userProvider.save(user);
    }

    @DeleteMapping("id")
    public void deleteUser(@PathVariable int id) throws IOException{
        userProvider.remove(id);
    }
}