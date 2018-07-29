package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Holiday;

public interface HolidayRepository extends CrudRepository<Holiday, Integer> {

}
