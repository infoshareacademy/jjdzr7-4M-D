package com.infoshareacademy.four_md.model.dto;

import com.infoshareacademy.four_md.model.Difficulty;
import com.infoshareacademy.four_md.model.DishType;
import com.infoshareacademy.four_md.model.Ratings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    private int id;
    @NotBlank(message = "{validation.empty}")
    @NotNull(message = "{validation.empty}")
    private String name;
    @NotBlank(message = "{validation.empty}")
    @NotNull(message = "{validation.empty}")
    private String preparationMethod;

    private List<Ingredients> ingredientsList = new ArrayList<>();
    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.number}")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0)
    private int estimatedCookingTime;
    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.number}")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0)
    private int calories;


    private List<Ratings> ratingsList = new ArrayList<>();

    private Difficulty difficulty;

    private DishType dishType;
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
