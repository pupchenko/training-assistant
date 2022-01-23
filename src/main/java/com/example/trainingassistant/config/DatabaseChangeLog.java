package com.example.trainingassistant.config;

import com.example.trainingassistant.model.Exercise;
import com.example.trainingassistant.dao.ExerciseRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "populateDatabase", author = "Artur")
    public void populateDatabase(ExerciseRepository expenseRepository) {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("barbellDeadlift","Barbell Deadlift", "Squat down and grasp a barbell with your hands roughly shoulder-width apart." +
                "Keep your chest up, pull your shoulders back and look straight ahead as you lift the bar. " +
                "Focus on taking the weight back onto your heels and keep the bar as close as possible to your body at all times. " +
                "Lift to thigh level, pause, then return under control to the start position."));
        exerciseList.add(new Exercise("barbellSquat","Barbell Squat", "Stand with your feet more than shoulder-width apart and hold a barbell across your upper back with an overhand grip – avoid resting it on your neck. Hug the bar into your traps to engage your upper back muscles. " +
                "Slowly sit back into a squat with head up, back straight and backside out. Lower until your hips are aligned with your knees, with your legs at 90 degrees – a deeper squat will be more beneficial but get the strength and flexibility first. " +
                "Drive your heels into the floor to push yourself explosively back up. Keep form until you’re stood up straight: that’s one."));
        exerciseList.add(new Exercise("kettlebellSwings","Kettlebell Swings", "Place a kettlebell a couple of feet in front of you. Stand with your feet slightly wider than shoulder-width apart and bend your knees to lean forward and grab the handle with both hands. " +
                "With your back flat, engage your lats to pull the weight between your legs (be careful with how deep you swing) then drive your hips forward and explosively pull the kettlebell up to shoulder height with your arms straight in front of you. " +
                "Return to the start position and repeat without pauses."));
        exerciseList.add(new Exercise("boxJumps", "Box Jumps", "Set yourself a comfortable distance from the box with feet shoulder width apart. " +
                "Drop quickly into a quarter squat, swing your arms and explode upwards to jump onto the box. Land as softly as possible. " +
                "Now step backwards off the box under control."));
        expenseRepository.insert(exerciseList);
    }
}
