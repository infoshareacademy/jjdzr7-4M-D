package com.infoshareacademy.four_md.model;

import com.infoshareacademy.four_md.model.dto.Recipe;

import java.time.LocalDate;
import java.util.Map;

public class Planner {
    private Map<LocalDate, Recipe> map;

    public Planner(Map<LocalDate, Recipe> map) {
        this.map = map;
    }

    public Map<LocalDate, Recipe> getMap() {
        return map;
    }

    public void setMap(Map<LocalDate, Recipe> map) {
        this.map = map;
    }

    public void addTask(LocalDate localDate, Recipe recipe) {
        this.map.put(localDate, recipe);
    }

    public void deleteTask(LocalDate date) {
        map.remove(date);
    }

    public void deleteAllTask() {
        map.clear();
    }
}
