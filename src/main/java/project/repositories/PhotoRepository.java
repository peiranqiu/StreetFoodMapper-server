package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.models.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer>{}