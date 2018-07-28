package project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import project.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.email=:email")
	Optional<User> findUserByEmail(
			@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE "
			+ "u.email=:email AND "
			+ "u.password=:password")
	Optional<User> findUserByCredentials(
			@Param("email") String email, 
			@Param("password") String password);
}
