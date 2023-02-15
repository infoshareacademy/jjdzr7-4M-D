package com.infoshareacademy.four_md.service.providers;

import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.StaticDtoMappers;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import com.infoshareacademy.four_md.service.jpaRepos.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
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
    public void remove(int userId) throws IOException {
        userRepo.deleteById(userId);
        userRepo.flush();
    }
}
