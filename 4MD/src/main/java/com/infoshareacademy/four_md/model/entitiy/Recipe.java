package com.infoshareacademy.four_md.model.entitiy;

import com.infoshareacademy.four_md.model.Difficulty;
import com.infoshareacademy.four_md.model.DishType;
import com.infoshareacademy.four_md.model.Ratings;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Recipes")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Recipe_seq" )
    @SequenceGenerator(name = "Recipe_seq",allocationSize = 1,sequenceName = "Recipe_seq")
    private int id;

    private String name;
    @OneToMany
    @JoinColumn
    private List<Ingredients> ingredientsList;

    private int estimatedCookingTime;

    private int calories;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = Ratings.class)
    private List<Ratings> ratingsList;

    private Difficulty difficulty;

    private DishType dishType;

    public Recipe(int id, String name, List<Ingredients> ingredientsList, int estimatedCookingTime, int calories, List<Ratings> ratingsList, Difficulty difficulty, DishType dishType) {
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.estimatedCookingTime = estimatedCookingTime;
        this.calories = calories;
        this.ratingsList = ratingsList;
        this.difficulty = difficulty;
        this.dishType = dishType;
    }
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredientsList=" + ingredientsList +
                ", estimatedCookingTime=" + estimatedCookingTime +
                ", calories=" + calories + " kcal" +
                ", cost=" + getCost() + " zł" +
                ", rating=" + ratingsList +
                ", difficulty=" + difficulty +
                ", dishType=" + dishType +
                '}';
    }
    public double getCost() {
        return ingredientsList.stream().mapToDouble(Ingredients::getPrice).sum();
    }
    private double averageRating() {
        double sum = ratingsList.stream().mapToDouble(Ratings::getNumVal).sum();
        return sum / (ratingsList.size());
    }

    public Integer roundAverageRating() {
        return Math.toIntExact(Math.round(averageRating()));
    }

    public List<Ingredients> ingredientListsCopy() {
        List<Ingredients> list = new ArrayList<>();
        for (Ingredients el : ingredientsList) {
            Ingredients ingredients = new Ingredients();
            ingredients.copyIngredients(el);
            list.add(ingredients);
        }
        return list;
    }

    public List<Ingredients> ingredientsListByPortion(int numberOfPortions) {
        List<Ingredients> list = new ArrayList<>(ingredientListsCopy());
        list.forEach(n -> n.setQuantity(n.getQuantity() * numberOfPortions));
        list.forEach(n -> n.setPrice(n.getPrice() * numberOfPortions));
        return list;
    }

}
