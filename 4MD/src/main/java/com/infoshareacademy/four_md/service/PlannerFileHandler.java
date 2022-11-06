package com.infoshareacademy.four_md.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.infoshareacademy.four_md.models.Planner;
import com.infoshareacademy.four_md.service.interfaces.PlannerProvider;

@Component
public class PlannerFileHandler extends  FileHandler<Planner> implements PlannerProvider {

    public PlannerFileHandler() throws IOException {
        super("./planners/",Planner.class);
    }

    @Override
    public Planner get(int Id) throws IOException {
        // TODO Auto-generated method stub
        return super.get(Id);
    }

    @Override
    public List<Planner> getAll() throws IOException {
        // TODO Auto-generated method stub
        return super.getAll();
    }

    @Override
    public void remove(int Id) throws IOException {
        // TODO Auto-generated method stub
        super.remove(Id);
    }

    @Override
    public void save(Planner planner) throws IOException {
        super.save(planner, planner.getId());
        
    }
    
}