package com.infoshareacademy.four_md.model;

public class Ingredients {
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
