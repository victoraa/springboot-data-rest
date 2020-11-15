package com.viewnext.api;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringDataRestApplication {
	@Autowired
	private UserRepository repository;

	/**
	 * Inicialización tras la construcción de la aplicacion
	 */
	@PostConstruct
	public void init() {
		User user1 = new User(10, "Pratik", "p2@gmail.com");
		repository.save(user1);

		repository.saveAll(Stream
				.of(new User(101, "Pratik", "p@gmail.com"), new User(102, "Dileep", "d@gmail.com"),
						new User(103, "Lav", "l@gmail.com"), new User(104, "Swat", "s@gmail.com"))
				.collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

}
