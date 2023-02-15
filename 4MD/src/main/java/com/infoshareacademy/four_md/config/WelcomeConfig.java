package com.infoshareacademy.four_md.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WelcomeConfig{

    @Bean
    public BCryptPasswordEncoder createEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        var userDb = new InMemoryUserDetailsManager();
        userDb.createUser(
                User.withUsername("mikolka")
                .password(passwordEncoder.encode("mikolka"))
                .roles("USER")
                .build());
        return userDb;
    }
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/welcome")
                .permitAll()
                .successForwardUrl("/BookCook")
        ;
        return http.build();
    }
}
