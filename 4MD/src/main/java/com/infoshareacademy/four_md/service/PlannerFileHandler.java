package com.infoshareacademy.four_md.service;

import com.infoshareacademy.four_md.model.Planner;
import com.infoshareacademy.four_md.service.interfaces.PlannerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PlannerFileHandler extends  FileHandler<Planner> implements PlannerProvider {

    public PlannerFileHandler() throws IOException {
        super("./planners/",Planner.class);
    }
}