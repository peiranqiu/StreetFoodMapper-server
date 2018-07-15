package project.repositories;
import project.models.Owner;

import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}