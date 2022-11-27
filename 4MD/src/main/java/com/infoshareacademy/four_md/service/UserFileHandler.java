package com.infoshareacademy.four_md.service;

import com.infoshareacademy.four_md.model.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserFileHandler extends FileHandler<User> implements UserProvider {

    public UserFileHandler() throws IOException {
        super("./src/main/resources/users/", User.class);
    }

}
