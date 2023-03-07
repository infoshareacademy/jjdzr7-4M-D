package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.UserCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("credentials",new UserCredentials());
        return "welcome";
    }
}
