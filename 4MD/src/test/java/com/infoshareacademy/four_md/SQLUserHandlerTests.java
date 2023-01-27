package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.model.Ratings;
import com.infoshareacademy.four_md.model.Unit;
import com.infoshareacademy.four_md.model.entitiy.Ingredients;
import com.infoshareacademy.four_md.model.entitiy.Recipe;
import com.infoshareacademy.four_md.model.entitiy.User;
import com.infoshareacademy.four_md.service.jpaRepos.RecipeRepository;
import com.infoshareacademy.four_md.service.jpaRepos.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Transactional
public class SQLUserHandlerTests {
    @Autowired
    private UserRepository users;
    @Autowired
    private RecipeRepository recipes;
    @Test
    public void testAddingUserToDB(){
        var user = new User();
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setListOfRecipes(new ArrayList<>());

        User retUser = users.saveAndFlush(user);
        //noinspection OptionalGetWithoutIsPresent
        User userFromDb = users.findById(retUser.getId()).get();

        Assertions.assertEquals(user.getName(),userFromDb.getName());
        Assertions.assertEquals(user.getSurname(),userFromDb.getSurname());

    }
    @Test
    public void testAddingUserWithRecipesToDB(){
        var user = new User();
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        user.getListOfRecipes().add(getNewRecipe("Shake",50));

        recipes.saveAllAndFlush(user.getListOfRecipes());
        User retUser = users.saveAndFlush(user);
        //noinspection OptionalGetWithoutIsPresent
        User userFromDb = users.findById(retUser.getId()).get();

        assertThat(userFromDb.getListOfRecipes().stream().anyMatch(s -> s.getName().equals("Koktail"))).isTrue();
        assertThat(userFromDb.getListOfRecipes().stream().anyMatch(s -> s.getName().equals("Shake"))).isTrue();

    }
    @Test
    public void testAddingRatedRecipesToDB(){
        var user = new User();
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        user.getListOfRecipes().add(getNewRecipe("Shake",50));


        recipes.saveAllAndFlush(user.getListOfRecipes());
        User retUser = users.saveAndFlush(user);
        //noinspection OptionalGetWithoutIsPresent
        User userFromDb = users.findById(retUser.getId()).get();

        assertThat(userFromDb.getListOfRecipes()).allMatch(s -> s.getRatingsList().get(0) == Ratings.R3);

    }
    @Test
    public void testAddingUserWithRecipesAndIngredientsToDB(){
        var user = new User();
        user.setName("Janusz");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        //
        user.getListOfRecipes().get(0).setIngredientsList(new ArrayList<>(
                List.of(
                        new Ingredients("elo",12, Unit.GRAM,32)
                )));

        recipes.saveAllAndFlush(user.getListOfRecipes());
        User retUser = users.saveAndFlush(user);
        //noinspection OptionalGetWithoutIsPresent
        User userFromDb = users.findById(retUser.getId()).get();

        assertThat(userFromDb.getListOfRecipes().get(0).getIngredientsList()).isNotEmpty();

    }
    private Recipe getNewRecipe(String name,int kcal) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setCalories(kcal);
        recipe.setRatingsList(new ArrayList<>());
        recipe.getRatingsList().add(Ratings.R3);
        return recipe;
    }
}
