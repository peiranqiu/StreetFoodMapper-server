package project.repositories;
import project.models.Truck;

import org.springframework.data.repository.CrudRepository;


public interface TruckRepository extends CrudRepository<Truck, Integer> {
}