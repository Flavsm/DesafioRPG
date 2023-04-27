package com.avanade.desafio.controller;

import com.avanade.desafio.model.Battle;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.service.BattleService;
import com.avanade.desafio.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api")
@Api( value = "BATTLE API REST", consumes = "application/json", produces = "application/json")
@CrossOrigin( origins = "*")
public class BattleController {

    @Autowired
    private BattleService battleService;


    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping( "/battle/list")
    @ApiOperation( "find a hero from the list" )
    public ResponseEntity<List< Battle >> getAll() {
        return new ResponseEntity<>( battleService.findAll(), HttpStatus.OK );
    }


    @GetMapping( "/battle/{id}" )
    @ApiOperation( "find a hero by its id" )
    public ResponseEntity< Battle > getById( @PathVariable( value = "id" ) Long battleId ) {
        return new ResponseEntity<>(battleService.findById(battleId), HttpStatus.OK);
    }

    @PostMapping("/battle")
    @ApiOperation("Setup Battle")
    public ResponseEntity<Battle> create(@RequestBody Battle battle) {
        return new ResponseEntity<>(battleService.create(battle), HttpStatus.CREATED);
    }

    @PutMapping( "/battle")
    @ApiOperation( "Update a battle")
    public ResponseEntity< Battle > update( @RequestBody Battle battle ) {
        return new ResponseEntity<>( battleService.update( battle ), HttpStatus.OK);
    }
}