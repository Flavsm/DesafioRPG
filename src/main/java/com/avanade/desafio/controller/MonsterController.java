package com.avanade.desafio.controller;

import com.avanade.desafio.model.Monster;
import com.avanade.desafio.service.MonsterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api")
@Api( value = "MONSTERS API REST")
@CrossOrigin( origins = "*")
public class MonsterController {
    @Autowired
    private MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }


    @GetMapping( "/monsters/list")
    @ApiOperation( "find a monster from the list" )
    public ResponseEntity<List<Monster>> getAll() {
        return new ResponseEntity<>( monsterService.findAll(), HttpStatus.OK );
    }

    @GetMapping( "/monsters/{id}" )
    @ApiOperation( "find a monster by its id" )
    public ResponseEntity< Monster > getById( @PathVariable( value = "id" ) Long heroesId ) {
        return new ResponseEntity<>(monsterService.findById(heroesId), HttpStatus.OK);
    }

    @PostMapping( "/monsters" )
    @ApiOperation( "Create a new monster" )
    public ResponseEntity< Monster > create( @RequestBody Monster monster ) {
        return new ResponseEntity<>( monsterService.create( monster ), HttpStatus.CREATED);
    }

    @PutMapping( "/monsters")
    @ApiOperation( "Update a monster")
    public ResponseEntity< Monster > update( @RequestBody Monster monster ) {
        return new ResponseEntity<>( monsterService.update( monster ), HttpStatus.OK);
    }

    @DeleteMapping( "/monsters")
    @ApiOperation( "Delete a monster")
    public ResponseEntity< HttpStatus > update( @RequestHeader Long monsterId ) {
        monsterService.delete( monsterId );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
