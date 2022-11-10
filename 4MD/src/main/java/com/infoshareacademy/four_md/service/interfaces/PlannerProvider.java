package com.infoshareacademy.four_md.service.interfaces;

import com.infoshareacademy.four_md.model.Planner;

import java.io.IOException;

public interface PlannerProvider {
    void save(Planner planner) throws IOException;
    Planner get() throws IOException;
}