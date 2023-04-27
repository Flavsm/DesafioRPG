package com.avanade.desafio.controller;

import com.avanade.desafio.model.Hero;
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
@Api( value = "HEROES API REST")
@CrossOrigin( origins = "*")
public class HeroController {

    @Autowired
    private HeroService heroService;


    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

//    @GetMapping("/heroes/list")
//    public Iterable<Hero> list() {
//        return heroService.list();
//    }

    @GetMapping( "/heroes/list")
    @ApiOperation( "find a hero from the list" )
    public ResponseEntity<List< Hero >> getAll() {
        return new ResponseEntity<>( heroService.findAll(), HttpStatus.OK );
    }


    @GetMapping( "/heroes/{id}" )
    @ApiOperation( "find a hero by its id" )
    public ResponseEntity< Hero > getById( @PathVariable( value = "id" ) Long heroesId ) {
        return new ResponseEntity<>(heroService.findById(heroesId), HttpStatus.OK);
    }

    @PostMapping( "/heroes" )
    @ApiOperation( "Create a new hero" )
    public ResponseEntity< Hero > create( @RequestBody Hero hero ) {
        return new ResponseEntity<>( heroService.create( hero ), HttpStatus.CREATED);
    }

    @PutMapping( "/heroes")
    @ApiOperation( "Update a hero")
    public ResponseEntity< Hero > update( @RequestBody Hero hero ) {
        return new ResponseEntity<>( heroService.update( hero ), HttpStatus.OK);
    }

    @DeleteMapping( "/heroes")
    @ApiOperation( "Delete a hero")
    public ResponseEntity< HttpStatus > update( @RequestHeader Long heroId ) {
        heroService.delete( heroId );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
