package com.footballapp.controller;

import com.footballapp.entity.Player;
import com.footballapp.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController{
    private final PlayerService service;

    public PlayerController(PlayerService service){
        this.service = service;
    }
    // Add/register player to a team
    @PostMapping("/team/{teamId}")
    public ResponseEntity<Player> addPlayer(@PathVariable Long teamId, @RequestBody Player player){
        Player savedPlayer = service.registerPlayer(teamId,player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
    // Get all Players
    @GetMapping
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }
    //get a player by ID
    @GetMapping("/{id}")
        public Player getPlayer(@PathVariable Long id) {
        return service.getPlayerBYID(id);
    }
    // Update player details
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updated){
        Player player =service.updatePlayer(id, updated);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    // Delete a player
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id){
        service.deletePlayer(id);
        return new ResponseEntity<>("Player deleted with id: " + id, HttpStatus.OK);
    }
    // Switch a player to another team
    @PutMapping("/{playerId}/switch/{teamId}")
    public ResponseEntity<Player> switchTeam(@PathVariable Long playerId, @PathVariable Long teamId){
        Player switchedPlayer = service.switchTeam (playerId, teamId);
        return new ResponseEntity<>(switchedPlayer,HttpStatus.OK);
    }

}