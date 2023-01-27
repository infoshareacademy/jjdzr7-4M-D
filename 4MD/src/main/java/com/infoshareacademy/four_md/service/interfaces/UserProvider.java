package com.infoshareacademy.four_md.service.interfaces;

import com.infoshareacademy.four_md.model.entitiy.User;

import java.io.IOException;

public interface UserProvider {

    User get(int userId) throws IOException;
    void save(User user) throws IOException;
    void remove(int userId) throws IOException;
}
