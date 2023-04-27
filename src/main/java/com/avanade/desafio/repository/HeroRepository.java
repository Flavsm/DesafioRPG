package com.avanade.desafio.repository;

import com.avanade.desafio.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository< Hero, Long> {
}
//public interface HeroRepository extends CrudRepository<Hero, Long> {
//}