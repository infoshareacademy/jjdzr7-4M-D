package com.infoshareacademy.four_md.model.entitiy;

import com.infoshareacademy.four_md.model.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ingredients")
public class IngredientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Ingredients_seq" )
    @SequenceGenerator(name = "Ingredients_seq",allocationSize = 1,sequenceName = "Ingredients_seq")
    private int id;
    private String name;
    private double quantity;
    private Unit unit;
    private double price;

}
