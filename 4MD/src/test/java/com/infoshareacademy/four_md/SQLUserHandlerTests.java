package com.infoshareacademy.four_md;

import com.infoshareacademy.four_md.model.Ratings;
import com.infoshareacademy.four_md.model.Unit;
import com.infoshareacademy.four_md.model.dto.Ingredients;
import com.infoshareacademy.four_md.model.dto.Recipe;
import com.infoshareacademy.four_md.model.dto.User;
import com.infoshareacademy.four_md.service.interfaces.UserProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class SQLUserHandlerTests {
    @Autowired
    private UserProvider users;
    @Test
    public void testAddingUserToDB() throws IOException {
        var user = new User();
        user.setUsername("Janusz");
        user.setSurname("Kowalski");

        users.save(user);
        User userFromDb = users.get(user.getId());

        Assertions.assertEquals(user.getUsername(),userFromDb.getUsername());
        Assertions.assertEquals(user.getSurname(),userFromDb.getSurname());

    }
    @Test
    public void testAddingUserWithRecipesToDB() throws IOException {
        var user = new User();
        user.setUsername("Janusz");
        user.setSurname("Kowalski");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        user.getListOfRecipes().add(getNewRecipe("Shake",50));


        users.save(user);
        User userFromDb = users.get(user.getId());

        assertThat(userFromDb.getListOfRecipes().stream().anyMatch(s -> s.getName().equals("Koktail"))).isTrue();
        assertThat(userFromDb.getListOfRecipes().stream().anyMatch(s -> s.getName().equals("Shake"))).isTrue();

    }
    @Test
    public void testAddingRatedRecipesToDB() throws IOException {
        var user = new User();
        user.setUsername("Janusz");
        user.setSurname("Kowalski");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        user.getListOfRecipes().add(getNewRecipe("Shake",50));


        users.save(user);
        User userFromDb = users.get(user.getId());

        assertThat(userFromDb.getListOfRecipes()).allMatch(s -> s.getRatingsList().get(0) == Ratings.R3);

    }
    @Test
    public void testAddingUserWithRecipesAndIngredientsToDB() throws IOException {
        var user = new User();
        user.setUsername("Janusz");
        user.setListOfRecipes(new ArrayList<>());
        //
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));
        //
        user.getListOfRecipes().get(0).setIngredientsList(new ArrayList<>(
                List.of(
                        new Ingredients("elo",12, Unit.GRAM,32)
                )));

        users.save(user);
        User userFromDb = users.get(user.getId());

        assertThat(userFromDb.getListOfRecipes().get(0).getIngredientsList()).isNotEmpty();

    }
    @Test
    public void testEditingUserWithRecipesToDB() throws IOException {
        var user = new User();
        user.setUsername("Janusz");
        user.setListOfRecipes(new ArrayList<>());
        user.getListOfRecipes().add(getNewRecipe("Koktail",100));

        users.save(user);
        User userFromDb = users.get(user.getId());

        assertThat(userFromDb.getListOfRecipes().get(0).getName()).isEqualTo("Koktail");
        // Phase 2
        User dbUser = users.get(user.getId());
        dbUser.getListOfRecipes().get(0).setName("Infoshare");

        users.save(dbUser);
        User anotherDbUser = users.get(dbUser.getId());

        assertThat(anotherDbUser.getListOfRecipes().get(0).getName()).isEqualTo("Infoshare");
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
