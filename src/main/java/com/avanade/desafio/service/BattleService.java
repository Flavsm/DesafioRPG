package com.avanade.desafio.service;

import com.avanade.desafio.exception.InvalidInputException;
import com.avanade.desafio.exception.ResourceNotFoundException;
import com.avanade.desafio.model.Battle;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public Battle create (Battle battle) {
//    heroes.setCreatedAt(LocalDateTime.now() );
        return this.battleRepository.save( battle );
    }
    public List< Battle > findAll(){
        return battleRepository.findAll();
    }

    public Battle findById( Long id) {
        return battleRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException("Battle not found with ID: " + id ));
    }

    public Battle update( Battle battle) {
        if (battle.getId() == null) {
            throw new InvalidInputException( "There is no Id");
        }
        return battleRepository.save( battle );
    }

    //initiate

    //attack

    //defense

    //damage

    //log

}
