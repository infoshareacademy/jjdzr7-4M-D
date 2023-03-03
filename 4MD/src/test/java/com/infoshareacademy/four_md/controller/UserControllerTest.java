package com.infoshareacademy.four_md.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.model.entitiy.UserEntity;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserProvider userProvider;

    @BeforeEach
    void setUp() {
        openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userProvider)).build();
    }

    @Test
    void shouldReturnUserById() throws Exception {
        User user = new User(1, "Dawid", "Morawski", new ArrayList<>());
        when(userProvider.get(1)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(MockMvcResultMatchers.view().name("userPage"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", user));
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserEntity user = new UserEntity(1, "Dawid", "Morawski", new ArrayList<>());
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/userPage"));
    }

    @Test
    void shouldUpdateUser() throws Exception {
        User user = new User(1, "Dawid", "Morawski", new ArrayList<>());
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/userPage"));
    }

    @Test
    void shouldDeleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/userPage"));
    }
}
