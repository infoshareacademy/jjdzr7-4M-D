package com.infoshareacademy.four_md.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping()
public class BookCookController {

    @GetMapping()
    public String getRecipes() throws IOException{
            return "Helo";
    }

}
