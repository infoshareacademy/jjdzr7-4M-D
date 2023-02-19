package com.infoshareacademy.four_md.service.jpaRepos;

import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import com.infoshareacademy.four_md.model.entitiy.SearchEngineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchEngineRepository extends JpaRepository<RecipeEntity, Integer> {

    List<RecipeEntity> findByName(String name);
    List<RecipeEntity> findByCaloriesBetween(Integer calMin, Integer calMax);
    //List<RecipeEntity> findByPriceBetween(Double priceMin, Double priceMax);
}
