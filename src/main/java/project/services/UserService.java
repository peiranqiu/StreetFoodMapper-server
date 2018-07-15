package project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.models.User;
import project.repositories.UserRepository;

import java.util.*;

@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/api/user")
	public Iterable<User> findAllUsers(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password) {
		if (username != null && password != null) {
			return userRepository.findUserByCredentials(username, password);
		} else if (username != null) {
			return userRepository.findUserByUsername(username);
		}
		return userRepository.findAll();
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId) {
		Optional<User> data = userRepository.findById(userId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	

	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = userRepository.findById(userId);
		if (data.isPresent()) {
			User user = data.get();
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());

			userRepository.save(user);
			return user;
		}
		return null;
	}

	@PostMapping("/api/login")
	public User loginUser(@RequestBody User user) {
		List<User> list = (List<User>) userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
		if(list==null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@PostMapping("/api/register")
	public User registerUser(@RequestBody User user) {
		List<User> list = (List<User>) userRepository.findUserByUsername(user.getUsername());
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
