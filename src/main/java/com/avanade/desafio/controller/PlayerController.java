package com.avanade.desafio.controller;

import com.avanade.desafio.model.Hero;
import com.avanade.desafio.model.Player;
import com.avanade.desafio.service.HeroService;
import com.avanade.desafio.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api")
@Api( value = "RPG API REST")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player/{id}")
    @ApiOperation( "find a player by its id" )
    public ResponseEntity< Player > getById( @PathVariable( value = "id" ) Long playerId ) {
        return new ResponseEntity<>(playerService.findById(playerId), HttpStatus.OK);
    }


    @PostMapping( "/player" )
    @ApiOperation( "Create a new player" )
    public ResponseEntity<Player> create(@RequestBody Player player ) {
        return new ResponseEntity<>( playerService.create( player ), HttpStatus.CREATED);
    }

    @PutMapping( "/player")
    @ApiOperation( "Update a player")
    public ResponseEntity< Player > update( @RequestBody Player player ) {
        return new ResponseEntity<>( playerService.update( player ), HttpStatus.OK);
    }

    @DeleteMapping( "/player")
    @ApiOperation( "Delete a player")
    public ResponseEntity< HttpStatus > update( @RequestHeader Long playerId ) {
        playerService.delete( playerId );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
