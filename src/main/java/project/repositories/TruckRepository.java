package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Truck;

public interface TruckRepository extends CrudRepository<Truck, Integer> {

}
