package com.example.trainingassistant.dao;

import com.example.trainingassistant.model.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends MongoRepository<Training, String> {

    @Query("{'userId' : ?0}")
    List<Training> findByUserId(String userId);

    @Query("{'id' : ?0 , 'userId' : ?1}")
    Optional<Training> findByIdAndUserId(String id, String userId);

    @Query(value = "{'id' : ?0 , 'userId' : ?1}", delete = true)
    void deleteByIdAndUserId(String id, String userId);
}
