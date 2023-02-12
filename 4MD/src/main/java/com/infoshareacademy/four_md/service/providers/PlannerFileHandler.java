package com.infoshareacademy.four_md.service.providers;

import com.google.gson.Gson;
import com.infoshareacademy.four_md.model.Planner;
import com.infoshareacademy.four_md.service.interfaces.PlannerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Component
public class PlannerFileHandler implements PlannerProvider {
    private final Gson gson = new Gson();

    @Override
    public Planner get() throws IOException {
        String file = Files.readString(Path.of("./planner.json"));
        return gson.fromJson(file,Planner.class);
    }

    @Override
    public void save(Planner obj) throws IOException {
        String value = gson.toJson(obj);
        Files.writeString(Path.of("./planner.json"),value);
    }
}