package com.footballapp.service;

import com.footballapp.entity.Player;
import com.footballapp.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository){
        this.repository =repository;
    }

    public Player savePlayer (Player player){
        return repository.save(player);
    }

    public List <Player> getAllPlayers(){
        return repository.findAll();
    }

    public Player getPlayerBYID(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletePlayer(Long id){
        repository.deleteById(id);
    }
}
