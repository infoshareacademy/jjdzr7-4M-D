package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.UserCredentials;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.providers.DbUserProvider;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class WelcomePageController {
    private DbUserProvider userProvider;
    private PasswordEncoder encoder;
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("credentials", new UserCredentials());
        return "welcome";
    }

    @SneakyThrows
    @GetMapping("/setup")
    public ResponseEntity<String> setupServer() {

        if (!userProvider.userExists("mikolka")) {
            userProvider.save(
                    new User(0,
                            "mikolka",
                            encoder.encode("mikolka"),
                            "Chajewski",
                            new ArrayList<>()));
            userProvider.save(
                    new User(0,
                            "daniel",
                            encoder.encode("mikolka"),
                            "Popielski",
                            new ArrayList<>()));
            return ResponseEntity.ok("User are ready to go");
        }
        return ResponseEntity.badRequest().body("Users already created");
    }
}
