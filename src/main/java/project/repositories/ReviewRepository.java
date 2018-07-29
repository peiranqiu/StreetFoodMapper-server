package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
