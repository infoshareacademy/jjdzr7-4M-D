package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.model.entitiy.UserEntity;
import com.infoshareacademy.four_md.service.StaticDtoMappers;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import com.infoshareacademy.four_md.service.jpaRepos.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbUserProvider implements UserProvider {
    private final UserRepository userRepo;
    private final DbRecipeProvider recipeProvider;

    public DbUserProvider(UserRepository userRepo, DbRecipeProvider recipeProvider){
        this.userRepo = userRepo;
        this.recipeProvider = recipeProvider;
    }
    @Override
    @Transactional
    public User get(int userId) throws IOException {
        //noinspection OptionalGetWithoutIsPresent
        return StaticDtoMappers.toDto(userRepo.findById(userId).get());
    }

    @Override
    @Transactional
    public void save(User user) throws IOException {
        var entity = StaticDtoMappers.toEntity(user);
        for (RecipeEntity recipe : entity.getListOfRecipes()) {
            recipeProvider.save(recipe);
        }
        userRepo.saveAndFlush(entity);
        user.setId(entity.getId());
    }

    @Override
    public void remove(int userId){
        userRepo.deleteById(userId);
        userRepo.flush();
    }
    public User findUser(String username){
        return StaticDtoMappers.toDto(userRepo.findByUsername(username));
    }
    @Override
    public void createUser(UserDetails user) {
        throw new RuntimeException("Not supported");
    }

    @Override
    @Transactional
    public boolean userExists(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(
                        entity.getUsername(),
                        entity.getPassword(),
                        new ArrayList<>(List.of(new SimpleGrantedAuthority("USER"))));
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void deleteUser(String username) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new RuntimeException("Not supported");
    }
}
