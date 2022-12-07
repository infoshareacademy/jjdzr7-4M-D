package com.infoshareacademy.four_md.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Ingredients {
    @Valid
    @NotNull(message = "{validation.empty}")
    @NotEmpty(message = "{validation.empty}")
    private String name;
    @Valid
    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.number}")
    private double quantity;
    private Unit unit;
    @Valid
    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.number}")
    private double price;

    public Ingredients(String name, double quantity, Unit unit, double price) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    public Ingredients() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
