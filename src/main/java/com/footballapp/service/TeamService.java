package com.footballapp.service;


import com.footballapp.entity.Team;
import com.footballapp.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;

    }

    // Create a new team
    public Team create (Team team){
        //optional check :check for dublicate Team name
        if(teamRepository.findByName(team.getName())!=null){
            throw new RuntimeException("Team with this name already exist");
        }
        return teamRepository.save(team);

    }

    //Get all teams

    public List <Team> getAllTeams(){
    return teamRepository.findAll();
    }

    //Get a specific team by ID
    public  Team getTeamByID(Long id){
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }
// Optional: check if a team has space for a player

    public boolean hasSpace(Team team){
        return team.getPlayers().size()<8;
    }

}
