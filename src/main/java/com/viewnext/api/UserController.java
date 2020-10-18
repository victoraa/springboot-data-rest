package com.viewnext.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository repoUser;

	@GetMapping("/count")
	public String countUsers() {
		return "==> " + repoUser.count();
	}

	@GetMapping("/hola")
	public String holaService() {

		return "Hola";
	}

	@GetMapping("/getAll")
	public List<User> getAllusers() {
		List<User> salida = new ArrayList<User>();
		Iterable<User> it = repoUser.findAll();
		for (User elUs : it) {
			salida.add(elUs);
		}
		return salida;
	}

	/**
	 * Ej http://localhost:9090/getId/10
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getId/{id}")
	public User getUserId(@PathVariable("id") Integer id) {
		return repoUser.findById(id).get();
	}

	@GetMapping("/getEmail/{email}")
	public User getUserEmail(@PathVariable("email") String mail) {
		return repoUser.findByEmail(mail).orElse(null);
	}

	/**
	 * http://localhost:9090/setUser?id=3&mail=hola@hola.com&name=pepe
	 * 
	 * @param id
	 * @param mail
	 * @param name
	 * @return
	 */
	@GetMapping("/setUser")
	public User setUser(@RequestParam Integer id, @RequestParam String mail, @RequestParam String name) {
		User usu2 = repoUser.save(new User(id, name, mail));
		return usu2;
	}
}
