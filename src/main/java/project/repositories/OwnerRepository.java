package project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import project.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	@Query("SELECT u FROM Owner u WHERE u.email=:email")
	Iterable<Owner> findOwnerByEmail(
			@Param("email") String email);
	
	@Query("SELECT u FROM Owner u WHERE "
			+ "u.email=:email AND "
			+ "u.password=:password")
	Iterable<Owner> findOwnerByCredentials(
			@Param("email") String email, 
			@Param("password") String password);

}
