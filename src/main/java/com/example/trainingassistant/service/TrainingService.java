package com.example.trainingassistant.service;

import com.example.trainingassistant.model.Training;
import com.example.trainingassistant.dao.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public List<Training> fetchTrainings(String userId) {
        return trainingRepository.findByUserId(userId);
    }

    public Optional<Training> findTrainingById(String id, String userId) {
        return trainingRepository.findByIdAndUserId(id, userId);
    }

    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    public void deleteTrainingById(String id, String userId) {
        trainingRepository.deleteByIdAndUserId(id, userId);
    }
}
