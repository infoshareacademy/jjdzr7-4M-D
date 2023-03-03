package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserProvider userProvider;

    @GetMapping("/{userId}")
    public ModelAndView getUserById(@PathVariable int userId) throws IOException {
        var user = userProvider.get(userId);
        var modelAndView = new ModelAndView("userPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) throws IOException {
        userProvider.save(user);
        var headers = new HttpHeaders();
        headers.setLocation(URI.create("/userPage"));
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable int userId, @RequestBody User user) throws IOException {
        user.setId(userId);
        userProvider.save(user);
        var headers = new HttpHeaders();
        headers.setLocation(URI.create("/userPage"));
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) throws IOException {
        userProvider.remove(userId);
        var headers = new HttpHeaders();
        headers.setLocation(URI.create("/userPage"));
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
