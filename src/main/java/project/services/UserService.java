package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.models.Favorite;
import project.models.Owner;
import project.models.User;
import project.repositories.FavoriteRepository;
import project.repositories.UserRepository;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	FavoriteRepository favoriteRepository;

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Optional<User> data = userRepository.findById(userId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/login/user")
	  @ResponseBody
	  public User userLogin(@RequestBody User user,
	                                HttpServletResponse response, HttpServletRequest request) {
	    String email = user.getEmail();
	    String password = user.getPassword();

	    HttpSession session = request.getSession();

	    if (email.equals("admin") && email.equals(password)) {
	      Optional<User> data = userRepository.findUserByCredentials(email, password);
	      if (data.isPresent()) {
	        User admin = data.get();
	        session.setAttribute("user", admin);
	        return admin;
	      }
	    }

	    Optional<User> data = userRepository.findUserByCredentials(email, password);
	    if (data.isPresent()) {
	      User currUser = data.get();
	      session.setAttribute("user", (User) currUser);
	      return currUser;
	    }
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    return null;
	  }
	
	@PostMapping("/api/register/user")
	  @ResponseBody
	  public User userRegister(@RequestBody User user,
	                                   HttpServletResponse response,
	                                   HttpServletRequest request) {
	    String email = user.getEmail();

	    HttpSession session = request.getSession();

	    Optional<User> data = userRepository.findUserByEmail(email);
	    if (!data.isPresent()) {
	      session.setAttribute("user", user);
	      return userRepository.save(user);
	    }
	    response.setStatus(HttpServletResponse.SC_CONFLICT);
	    return null;
	  }
	
	@PostMapping("/api/user")
	  public User createUser(@RequestBody User user, 
				HttpServletResponse response) {
	    String email = user.getEmail();
	    Optional<User> data = userRepository.findUserByEmail(email);
	    if (!data.isPresent()) {
	      return userRepository.save(user);
	    }
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		return null;
	  }
	
	  @PutMapping("/api/profile/user/{userId}")
	  public User updateUserProfile(@PathVariable("userId") int userId, @RequestBody User user) {
	    Optional<User> data = userRepository.findById(userId);
	    if (data.isPresent()) {
	      User res = data.get();
	      if (!user.getPassword().equals(res.getPassword())) {
	        res.setPassword(user.getPassword());
	      }
	      if (!user.getEmail().equals(res.getEmail())) {
		        res.setEmail(user.getEmail());
		      }
	      return userRepository.save(res);
	    }
	    return null;
	  }
	
	  @PostMapping("/api/logout/user")
	  public void userLogout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	      session.invalidate();
	    }
	  }
	  
	  @GetMapping("/api/session/user")
	  public User findCurrentUser(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("user") != null) {
	      return (User) session.getAttribute("user");
	    }
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    return null;
	  }
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		
		Optional<User> userOptional = userRepository.findById(userId);
	    if (userOptional.isPresent()) {
	      User user = userOptional.get();
	      // remove related favorites
	      List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
	      for (Favorite fav : favorites) {
	        if (fav.getUser().getId() == userId) {
	          favoriteRepository.deleteById(fav.getId());
	        }
	      }}
		userRepository.deleteById(userId);
	}

	@GetMapping("/api/user")
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}


	
}
