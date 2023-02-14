package com.infoshareacademy.four_md.service.jpaRepos;

import com.infoshareacademy.four_md.model.entitiy.SearchEngineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchEngineRepository extends JpaRepository<SearchEngineEntity, Integer> {

    List<SearchEngineEntity> findByName(String name);
    List<SearchEngineEntity> findByCaloriesBetween(Integer calMin, Integer calMax);
    List<SearchEngineEntity> findByPriceBetween(Double priceMin, Double priceMax);
}
