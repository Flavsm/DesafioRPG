package com.avanade.desafio;


import com.avanade.desafio.model.Hero;
import com.avanade.desafio.model.Monster;
import com.avanade.desafio.service.HeroService;
import com.avanade.desafio.service.MonsterService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(HeroService heroService) {
		return args -> {
			//read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Hero>> typeReference = new TypeReference<List<Hero>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/heroes.json");
			try {
				List<Hero> heroes = mapper.readValue(inputStream, typeReference);
				heroService.save(heroes);
				System.out.println("Heroes Saved");
			} catch (IOException e) {
				System.out.println( "Unable to save heroes: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runner1(MonsterService monsterService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Monster>> typeReference = new TypeReference<List<Monster>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/monsters.json");
			try {
				List<Monster> monsters = mapper.readValue(inputStream, typeReference);
				monsterService.save(monsters);
				System.out.println("Monsters Saved");
			} catch (IOException e) {
				System.out.println( "Unable to save monsters: " + e.getMessage() );
			}
		};
	}
}
