package com.infoshareacademy.four_md.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {

    @GetMapping("/welcome")
    public String welcome(RequestEntity info) {
        return "welcome";
    }
}
