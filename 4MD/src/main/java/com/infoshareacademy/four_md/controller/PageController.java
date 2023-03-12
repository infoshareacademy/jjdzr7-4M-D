package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.UserCredentials;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.providers.DbUserProvider;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@Data
@RequiredArgsConstructor
public class PageController {

    private final DbUserProvider dbUserProvider;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("credentials",new UserCredentials());
        return "welcome";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register_success")
    public String processRegister(@ModelAttribute("user") User user) throws IOException {
        System.out.println(user);
        dbUserProvider.save(user);
        return "register_success";
    }

}
