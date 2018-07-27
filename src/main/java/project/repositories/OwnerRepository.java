package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Owner;
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

}
