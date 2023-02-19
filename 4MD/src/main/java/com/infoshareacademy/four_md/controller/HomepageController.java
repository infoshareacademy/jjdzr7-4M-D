package com.infoshareacademy.four_md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/home")
    public String homepage() {
        return "index";
    }
}
