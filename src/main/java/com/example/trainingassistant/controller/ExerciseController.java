package com.example.trainingassistant.controller;

import com.example.trainingassistant.model.Exercise;
import com.example.trainingassistant.service.ExerciseService;
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

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> fetchExercises() {
        return ResponseEntity.ok(exerciseService.fetchExercises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> findExercise(@PathVariable String id) {
        return exerciseService.findExerciseByName(id)
                .map(exercise -> ResponseEntity.ok().body(exercise))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @RolesAllowed("admin_role")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Exercise> saveExercise(@Valid @RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.saveExercise(exercise));
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("admin_role")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteExerciseById(@PathVariable String id) {
        exerciseService.deleteExerciseByName(id);
        return ResponseEntity.noContent().build();
    }
}
