package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Favorite;

public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

}
