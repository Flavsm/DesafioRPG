package com.avanade.desafio.service;

import com.avanade.desafio.exception.InvalidInputException;
import com.avanade.desafio.exception.ResourceNotFoundException;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.model.Player;
import com.avanade.desafio.repository.HeroRepository;
import com.avanade.desafio.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create (Player player) {
//    heroes.setCreatedAt(LocalDateTime.now() );
        return this.playerRepository.save( player );
    }
    public Player findById( Long id) {
        return playerRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException("Player not found with ID: " + id ));
    }

    public void delete( Long id) {
        playerRepository.deleteById( id );
    }

    public Player update( Player player) {
        if (player.getId() == null) {
            throw new InvalidInputException( "There is no Id");
        }
        return playerRepository.save( player );
    }

}
