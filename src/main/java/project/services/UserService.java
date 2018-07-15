package com.example.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;

import java.util.*;

@RestController
public class UserService {
	@Autowired
	UserRepository repository;

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}

	@GetMapping("/api/user")
	public Iterable<User> findAllUsers(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password) {
		if (username != null && password != null) {
			return repository.findUserByCredentials(username, password);
		} else if (username != null) {
			return repository.findUserByUsername(username);
		}
		return repository.findAll();
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId) {
		Optional<User> data = repository.findById(userId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	

	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = repository.findById(userId);
		if (data.isPresent()) {
			User user = data.get();
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setEmail(newUser.getEmail());
			user.setPhone(newUser.getPhone());
			user.setDateOfBirth(newUser.getDateOfBirth());
			user.setRole(newUser.getRole());
			user.setPassword(newUser.getPassword());

			repository.save(user);
			return user;
		}
		return null;
	}

	@PostMapping("/api/login")
	public User loginUser(@RequestBody User user) {
		List<User> list = (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
		if(list==null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@PostMapping("/api/register")
	public User registerUser(@RequestBody User user) {
		List<User> list = (List<User>) repository.findUserByUsername(user.getUsername());
		if(list==null || list.isEmpty()) {
			
			return createUser(user);
		}
		return null;
	}
	
	

	@PutMapping("/api/profile")
	public User updateProfile(@PathVariable("userId") int userId, @RequestBody User user) {
		return updateUser(userId, user);
	}
	
}
