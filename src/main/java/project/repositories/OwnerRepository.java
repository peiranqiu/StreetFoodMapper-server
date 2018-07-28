package project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import project.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	@Query("SELECT u FROM Owner u WHERE u.email=:email")
	Optional<Owner> findOwnerByEmail(
			@Param("email") String email);
	
	@Query("SELECT u FROM Owner u WHERE "
			+ "u.email=:email AND "
			+ "u.password=:password")
	Optional<Owner> findOwnerByCredentials(
			@Param("email") String email, 
			@Param("password") String password);
}
