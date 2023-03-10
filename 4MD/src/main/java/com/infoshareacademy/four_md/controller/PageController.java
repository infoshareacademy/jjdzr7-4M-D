package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.UserCredentials;
import com.infoshareacademy.four_md.model.entitiy.UserEntity;
import com.infoshareacademy.four_md.service.jpaRepos.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
@RequiredArgsConstructor
public class PageController {

    private final UserRepository userRepository;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("credentials",new UserCredentials());
        return "welcome";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register_success")
    public String processRegister(UserEntity user) {
        userRepository.save(user);
        return "register_success";
    }

}
