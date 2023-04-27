package com.avanade.desafio.service;

import com.avanade.desafio.exception.InvalidInputException;
import com.avanade.desafio.exception.ResourceNotFoundException;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.model.Monster;

import com.avanade.desafio.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonsterService {


    @Autowired
    private MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Iterable<Monster> list() {
        return monsterRepository.findAll();
    }

    public Monster save(Monster monster) {
        return monsterRepository.save(monster);
    }

    public Iterable<Monster> save(List<Monster> monsters) {
        return monsterRepository.saveAll(monsters);
    }

    public Monster create (Monster monster) {
//        monster.setCreatedAt(LocalDateTime.now() );
        return this.monsterRepository.save( monster );
    }

    public List< Monster > findAll(){
        return monsterRepository.findAll();
    }

    public Monster findById( Long id) {
        return monsterRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException("Hero not found with ID: " + id ));
    }

    public void delete( Long id) {
        monsterRepository.deleteById( id );
    }

    public Monster update( Monster monster) {
        if (monster.getId() == null) {
            throw new InvalidInputException( "There is no Id");
        }
        return monsterRepository.save( monster );
    }
}
