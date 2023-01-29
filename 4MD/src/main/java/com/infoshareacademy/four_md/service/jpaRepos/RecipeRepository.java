package com.infoshareacademy.four_md.service.jpaRepos;

import com.infoshareacademy.four_md.model.entitiy.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity,Integer> {
}
