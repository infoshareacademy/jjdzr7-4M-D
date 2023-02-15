package com.infoshareacademy.menu;

enum UserMenuOptionsEnum {
    EXIT(0, "Exit"),
    SEARCH_RECIPE(1, "Search recipe"),
    ADD_RECIPE(2, "Add recipe"),
    REMOVE_RECIPE(3, "Remove recipe"),
    EDIT_RECIPE(4, "Edit recipe"),
    ADD_RECIPE_TO_PLANNER(5, "Add recipe to planer"),
    REMOVE_RECIPE_FROM_PLANNER(6, "Remove recipe from planer"),
    SHOW_PLANNER(7, "Show planer");

    private final int value;
    private final String description;

    UserMenuOptionsEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static void printMenu() {
        for (UserMenuOptionsEnum userMenuOptionsEnum : UserMenuOptionsEnum.values()) {
            System.out.println(userMenuOptionsEnum);
        }
    }

    @Override
    public String toString() {
        return value + ". " + description;
    }
}
