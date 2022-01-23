package com.example.trainingassistant.controller;

import com.example.trainingassistant.model.Training;
import com.example.trainingassistant.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping
    public ResponseEntity<List<Training>> fetchTrainings(Principal principal) {
        String userId = principal.getName();
        return ResponseEntity.ok().body(trainingService.fetchTrainings(userId));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTraining(@PathVariable String id, Principal principal) {
        return trainingService.findTrainingById(id, principal.getName())
                .map(training -> ResponseEntity.ok().body(training))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Training> saveTraining(@Valid @RequestBody Training training, Principal principal) {
        training.setUserId(principal.getName());
        return ResponseEntity.ok().body(trainingService.saveTraining(training));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteTrainingById(@PathVariable String id, Principal principal) {
        trainingService.deleteTrainingById(id, principal.getName());
        return ResponseEntity.noContent().build();
    }

}
