package com.avanade.desafio.service;

import com.avanade.desafio.exception.InvalidInputException;
import com.avanade.desafio.exception.ResourceNotFoundException;
import com.avanade.desafio.model.Hero;
import com.avanade.desafio.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

   public Iterable<Hero> save(List<Hero> heroes) {
       return heroRepository.saveAll(heroes);
   }

  public Hero create (Hero hero) {
//    heroes.setCreatedAt(LocalDateTime.now() );
    return this.heroRepository.save( hero );
  }

  public List< Hero > findAll(){
      return heroRepository.findAll();
  }

  public Hero findById( Long id) {
      return heroRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException("Hero not found with ID: " + id ));
  }

  public void delete( Long id) {
      heroRepository.deleteById( id );
  }

  public Hero update( Hero hero) {
      if (hero.getId() == null) {
          throw new InvalidInputException( "There is no Id");
      }
      return heroRepository.save( hero );
  }
}
