package com.spring.data.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.data.jpa.demo.controller.ActorGenreMovieController;

@SpringBootApplication
public class SpringDataJpaDemo001Application implements CommandLineRunner {

	@Autowired
	private ActorGenreMovieController actorGenreMovieController;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemo001Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		actorGenreMovieController.run();

	}
}
