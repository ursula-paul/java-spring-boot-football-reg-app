package com.footballapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class  Team{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique= true, nullable = false)
    private String name;

    @OneToMany (mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();


    // Getters and Setters

    public Long getId() {return id;}
    public String getName() { return name;};
    public void setName(String Name) {this.name = name;}
    public List<Player>getPlayers (){return players;}


}


