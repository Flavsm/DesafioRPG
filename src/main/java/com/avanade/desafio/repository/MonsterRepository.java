package com.avanade.desafio.repository;

import com.avanade.desafio.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository< Monster, Long> {
}
