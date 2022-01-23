package com.example.trainingassistant.service;

import com.example.trainingassistant.model.Exercise;
import com.example.trainingassistant.dao.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public List<Exercise> fetchExercises() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> findExerciseByName(String name) {
        return exerciseRepository.findByName(name);
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExerciseByName(String name) {
        exerciseRepository.deleteByName(name);
    }
}
