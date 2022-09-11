package com.infoshareacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesProvider {
    public static List<Recipe> getRecipes() {
        return List.of(
                new Recipe(1, "Magiczne ciasto", List.of("mąka pszenna", "mleko 3,2%", "jajka (6)", "cytryna", "cukier waniliowy", "cukier puder", "masło"), 45, 2, 500, 10, "Słodkości"),
                new Recipe(2, "Pieczeń ze schabu", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Mięsne"),
                new Recipe(3, "Ekspresowe ciasto", List.of("jajka", "cukier", "mleko"), 10, 1, 500, 10, "Słodkości"),
                new Recipe(4, "Naleśniki z kurczakiem w sosie bolognese", List.of("gotowe naleśniki", "filet z piersi kurczaka"), 30, 3, 500, 10, "Mięsne"),
                new Recipe(5, "Sznycelki drobiowe po francusku", List.of("piersi z kurczaka", "mąka pszenna"), 30, 3, 500, 10, "Mięsne"),
                new Recipe(6, "Kalafior zapiekany z mięsem mielonym", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Słodkości"),
                new Recipe(7, "Ciasto na słodkie naleśniki", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Słodkości"),
                new Recipe(8, "Serowe w kratkę", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Słodkości"),
                new Recipe(9, "Roladki z szynki", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Słodkości"),
                new Recipe(10, "Sernik wiedeński z borówkami", List.of("schab środkowy", "kwaśne jabłko"), 120, 3, 500, 10, "Słodkości")
        );
    }
}