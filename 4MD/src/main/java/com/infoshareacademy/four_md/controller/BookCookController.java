package com.infoshareacademy.four_md.controller;

import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.service.jpaRepos.SearchEngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BookCook")
@RequiredArgsConstructor
public class BookCookController {

    private final SearchEngineRepository searchEngineRepository;

    @RequestMapping("/recipes/search/{name}")
    public List<RecipeEntity> findByNameContains(@PathVariable String name) {
        return searchEngineRepository.findByNameContains(name);
    }

    @RequestMapping(value = "/recipes/search/calories/", params = {"calMin", "calMax"})
    public List<RecipeEntity> findByCaloriesBetween(@PathVariable int calMin, @PathVariable int calMax) {
        return searchEngineRepository.findByCaloriesBetween(calMin, calMax);
    }
}
