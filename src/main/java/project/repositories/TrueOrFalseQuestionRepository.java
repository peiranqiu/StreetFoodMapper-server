package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.TrueOrFalseQuestion;

public interface TrueOrFalseQuestionRepository extends CrudRepository <TrueOrFalseQuestion, Integer>{

}
