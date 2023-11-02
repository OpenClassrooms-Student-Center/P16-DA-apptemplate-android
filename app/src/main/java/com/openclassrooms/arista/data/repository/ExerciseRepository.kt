package com.openclassrooms.arista.data.repository

import com.openclassrooms.arista.data.dao.ExerciseDtoDao
import com.openclassrooms.arista.domain.model.Exercise

class ExerciseRepository(private val exerciseDao: ExerciseDtoDao) {

    // Get all exercises
    suspend fun getAllExercises(): List<Exercise> {
        return exerciseDao.getAllExercises().map { it.toExercise() }
    }

    // Add a new exercise
    suspend fun addExercise(exercise: Exercise) {
        exerciseDao.insertExercise(exercise.toDto())
    }


    // Delete an exercise
    suspend fun deleteExercise(exercise: Exercise) {
        // If there is no id, you can raise an exception and catch it in the use case and viewmodel
        exercise.id?.let {
            exerciseDao.deleteExerciseById(
                id = exercise.id,
            )
        }
    }
}
