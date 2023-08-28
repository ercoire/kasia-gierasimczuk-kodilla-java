package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseListTestSuite {

    @Test
    public void shouldUpdateMentor(){
        //Given
        ExerciseList loopsExercises = new LoopsExercises();
        ExerciseList projectPatterns = new ProjectPatterns();
        Mentor adamJohnson = new Mentor(" Adam Johnson");
        Mentor macyBrown = new Mentor("Macy Brown");
        Mentor amandaWilliams = new Mentor("Amanda Williams");
        loopsExercises.registerObserver(adamJohnson);
        loopsExercises.registerObserver(amandaWilliams);
        projectPatterns.registerObserver(macyBrown);
        projectPatterns.registerObserver(amandaWilliams);

        //When
        loopsExercises.addExercise("Creating WHILE");
        loopsExercises.addExercise("FOR EACH - extended");
        loopsExercises.addExercise("Combining loops");
        projectPatterns.addExercise("Singleton for logs");
        projectPatterns.addExercise("Strategy in social media project");
        projectPatterns.addExercise("Using Factory for invoicing");

        //Then
        assertEquals(3, adamJohnson.getUpdateCount());
        assertEquals(3, macyBrown.getUpdateCount());
        assertEquals(6, amandaWilliams.getUpdateCount());
    }
}
