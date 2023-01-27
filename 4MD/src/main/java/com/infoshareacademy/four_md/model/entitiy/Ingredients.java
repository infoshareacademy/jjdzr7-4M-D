package com.infoshareacademy.four_md.model.entitiy;

import com.infoshareacademy.four_md.model.Unit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Ingredients_seq" )
    @SequenceGenerator(name = "Ingredients_seq",allocationSize = 1,sequenceName = "Ingredients_seq")
    private int id;
    private String name;
    private double quantity;
    private Unit unit;
    private double price;

    public Ingredients(String name, double quantity, Unit unit, double price) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", price=" + price + " zł" +
                '}';
    }

    public void copyIngredients(Ingredients ingredients) {
        name = ingredients.getName();
        quantity = ingredients.getQuantity();
        unit = ingredients.getUnit();
        price = ingredients.getPrice();
    }
}
