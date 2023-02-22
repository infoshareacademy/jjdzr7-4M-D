package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.SearchEngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BookCook")
@RequiredArgsConstructor
public class BookCookController {

    private final SearchEngineRepository searchEngineRepository;

    @GetMapping("/recipes/search")
    public List<RecipeEntity> findByNameContains(@RequestParam String name) {
        return searchEngineRepository.findByNameContains(name);
    }

    @GetMapping(value = "/recipes/search/calories/", params = {"calMin", "calMax"})
    public List<RecipeEntity> findByCaloriesBetween(@RequestParam(defaultValue = "0") int calMin,
                                                    @RequestParam(defaultValue = "9999") int calMax) {
        return searchEngineRepository.findByCaloriesBetween(calMin, calMax);
    }
}
