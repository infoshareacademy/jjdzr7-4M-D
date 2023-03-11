package com.infoshareacademy.four_md.model.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Users_seq" )
    @SequenceGenerator(name = "Users_seq",allocationSize = 1,sequenceName = "Users_seq")
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String surname;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private List<RecipeEntity> listOfRecipes = new ArrayList<>();
}