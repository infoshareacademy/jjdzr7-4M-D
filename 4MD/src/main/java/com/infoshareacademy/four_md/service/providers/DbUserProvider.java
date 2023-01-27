package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.entitiy.Recipe;
import com.infoshareacademy.four_md.model.entitiy.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import com.infoshareacademy.four_md.service.jpaRepos.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
@Component
@Transactional
public class DbUserProvider implements UserProvider {
    private final UserRepository userRepo;
    private final DbRecipeProvider recipeProvider;

    public DbUserProvider(UserRepository userRepo, DbRecipeProvider recipeProvider){

        this.userRepo = userRepo;
        this.recipeProvider = recipeProvider;
    }
    @Override
    public User get(int userId) throws IOException {
        return userRepo.findById(userId).get();
    }

    @Override
    public void save(User user) throws IOException {
        userRepo.save(user);
        for (Recipe recipe : user.getListOfRecipes()) {
            recipeProvider.save(recipe);
        }
    }

    @Override
    public void remove(int userId) throws IOException {
        userRepo.deleteById(userId);
    }
}
