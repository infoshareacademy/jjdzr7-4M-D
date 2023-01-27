package com.infoshareacademy.four_md.service.jpaRepos;

import com.infoshareacademy.four_md.model.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
