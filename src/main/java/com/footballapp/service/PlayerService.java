package com.footballapp.service;

import com.footballapp.entity.Player;
import com.footballapp.entity.Team;
import com.footballapp.repository.PlayerRepository;
import com.footballapp.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository =teamRepository;
    }

    // save/update player (internal)

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    //Get all players
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    // Get player by ID
    public Player getPlayerBYID(Long id){
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    // Delete player
    public void deletePlayer (Long id){
        playerRepository.deleteById(id);
    }

    //Register player to a team
     public Player registerPlayer (Long teamId, Player player){
        Team team =teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        // Max 8 players

        if (team.getPlayers().size() >=8){
            throw new RuntimeException("Team already has 8 players");
        }

        // Generate custom player code: first 3 letters of name + level +01

         String codePrefix = player.getFullName().length() >=3 ?
                 player.getFullName().substring(0,3).toUpperCase():
                 player.getFullName().toUpperCase();
        player.setPlayerCode(codePrefix + player.getCurrentLevel() + "01");

        // Assign team
         player.setTeam(team);

         return playerRepository.save(player);
     }

     // Update player details
    public Player updatePlayer(Long id, Player updated){
        Player existing = getPlayerBYID(id);

        existing.setFullName(updated.getFullName() !=null? updated.getFullName():existing.getFullName());
        existing.setPosition(updated.getPosition() !=null? updated.getPosition() : existing.getPosition());
        existing.setCurrentLevel(updated.getCurrentLevel()!= null? updated.getCurrentLevel():existing.getCurrentLevel());
        existing.setCourseOfStudy(updated.getCourseOfStudy() !=null? updated.getCourseOfStudy() : existing.getCourseOfStudy());
        existing.setNationality(updated.getNationality()!=null?updated.getNationality():existing.getNationality());

        return playerRepository.save(existing);
    }

    // switch player to another team

    public Player switchTeam (Long playerId,Long teamId){
        Player player = getPlayerBYID(playerId);
        Team newTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        // Max 8 players in new team
        if (newTeam.getPlayers().size() >=8){
            throw new RuntimeException("new team already has 8 players");
        }

        // Assign new team
        player.setTeam(newTeam);
        return playerRepository.save(player);
        }

    }














