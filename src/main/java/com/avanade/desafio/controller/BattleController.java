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

    @PostMapping("/battle")
    @ApiOperation("Setup Battle")
    public ResponseEntity<Battle> create(@RequestBody Battle battle) {
        return new ResponseEntity<>(battleService.create(battle), HttpStatus.CREATED);
    }
}