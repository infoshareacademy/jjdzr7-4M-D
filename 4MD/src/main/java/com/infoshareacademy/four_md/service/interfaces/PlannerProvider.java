package com.infoshareacademy.four_md.service.interfaces;

import java.io.IOException;
import java.util.List;

import com.infoshareacademy.four_md.models.Planner;

public interface PlannerProvider {
    void save(Planner planner) throws IOException;

    void remove(int plannerId) throws IOException;

    Planner get(int plannerId) throws IOException;

    List<Planner> getAll() throws IOException;
}