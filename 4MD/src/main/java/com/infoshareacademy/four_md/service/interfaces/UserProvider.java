package com.infoshareacademy.four_md.service.interfaces;

import com.infoshareacademy.four_md.model.dto.User;
import org.springframework.security.provisioning.UserDetailsManager;

import java.io.IOException;

public interface UserProvider extends UserDetailsManager {

    User get(int userId) throws IOException;
    void save(User user) throws IOException;
    void remove(int userId) throws IOException;
     User findUser(String username);
}
