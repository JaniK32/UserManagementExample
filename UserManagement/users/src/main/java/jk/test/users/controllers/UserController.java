package jk.test.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jk.test.users.dao.User;
import jk.test.users.storage.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private final UserRepository repository;

	UserController(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	@GetMapping("/users")
	List<User> all() {
		return repository.findAll();
	}
	
	@PostMapping("/user")
	User createUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
