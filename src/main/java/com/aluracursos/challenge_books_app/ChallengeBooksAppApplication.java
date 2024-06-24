package com.aluracursos.challenge_books_app;

import com.aluracursos.challenge_books_app.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeBooksAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBooksAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.displayMenu();
	}
}
