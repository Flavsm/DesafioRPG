package com.avanade.desafio.service;

import com.avanade.desafio.model.Battle;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //initiate

    //attack

    //defense

    //damage

    //log

}
