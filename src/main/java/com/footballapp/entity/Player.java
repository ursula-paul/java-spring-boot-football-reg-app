package com.footballapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="players")
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String fullName;
    private String currentLevel;
    private String courseOfStudy;
    private String position;


// Getters & Setters

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getCurrentLevel() {return currentLevel;}
    public void setCurrentLevel(String currentLevel) {this.currentLevel = currentLevel;}

    public String getCourseOfStudy() {return courseOfStudy;}
    public void setCourseOfStudy (String courseOfStudy ) {this.courseOfStudy = courseOfStudy;}

    public String getPosition() {return position;}
    public void setPosition (String position ){this.position = position;}
}