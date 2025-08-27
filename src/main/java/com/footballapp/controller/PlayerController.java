package com.footballapp.controller;

import com.footballapp.entity.Player;
import com.footballapp.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController{
    private final PlayerService service;

    public PlayerController(PlayerService service){
        this.service = service;
    }


    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return service.savePlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
        public Player getPlayer(@PathVariable Long id) {
        return service.getPlayerBYID(id);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        service.deletePlayer(id);
        return "Player deleted with id: " + id;
    }
}