package com.footballapp.controller;

import com.footballapp.entity.Team;
import com.footballapp.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController{
    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService =teamService;
    }

    // Get all teams

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        List <Team> teams =teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    //Get a specific team
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id){
        Team team = teamService.getTeamByID(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}

