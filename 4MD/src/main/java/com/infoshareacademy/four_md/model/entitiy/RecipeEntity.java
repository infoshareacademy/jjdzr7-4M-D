package com.infoshareacademy.four_md.model.entitiy;

import com.infoshareacademy.four_md.model.Difficulty;
import com.infoshareacademy.four_md.model.DishType;
import com.infoshareacademy.four_md.model.Ratings;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Recipe_seq" )
    @SequenceGenerator(name = "Recipe_seq",allocationSize = 1,sequenceName = "Recipe_seq")
    private int id;

    private String name;
    @Column(length = 5000)
    private String preparationMethod;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private List<IngredientsEntity> ingredientsList = new ArrayList<>();

    private int estimatedCookingTime;

    private int calories;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = Ratings.class)
    private List<Ratings> ratingsList = new ArrayList<>();
    @Enumerated(EnumType.ORDINAL)
    private Difficulty difficulty;
    @Enumerated(EnumType.ORDINAL)
    private DishType dishType;

}
