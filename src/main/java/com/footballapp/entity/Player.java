
package com.footballapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="players")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String playerCode; // Custom ID

    @Column (nullable = false)
    private String fullName;

    @Column (nullable = false)
    private String currentLevel; // e.g, 200L

    private String courseOfStudy; // optional
    private String nationality; // optional

    @Column(nullable = false)
    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

// Helper method: checks if player can play (100L restriction)

    public boolean canPlay(){
        return !this.currentLevel.equalsIgnoreCase("100L");
    }

    public void setTeam(Team team) {

    }

    /*

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
     */
}