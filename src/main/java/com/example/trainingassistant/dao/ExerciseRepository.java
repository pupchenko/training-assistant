package com.example.trainingassistant.dao;

import com.example.trainingassistant.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {

    @Query("{'name' : ?0}")
    Optional<Exercise> findByName(String id);

    @Query(value = "{'name' : ?0}", delete = true)
    void deleteByName(String name);
}
