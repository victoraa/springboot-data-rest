package com.viewnext.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * Tarea programada sobre la clases del proyecto
 */
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private UserRepository repository;

	@Scheduled(fixedRate = 2000)
	public void reportCurrentTime() {
		final String hora = dateFormat.format(new Date());
		log.info("The time is now {}", hora);
		User user1 = new User(this.getRandom(), "Pepe_" + hora, "pruebaSched@gmail.com");
		log.info("-->Inserting Object User:" + user1.getName());
		repository.save(user1);

	}

	private int getRandom() {
		Random random = new Random();
		return random.nextInt(99999);
	}
}
