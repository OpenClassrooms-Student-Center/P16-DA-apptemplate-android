package com.openclassrooms.arista.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.openclassrooms.arista.data.entity.ExerciseDto

@Dao
interface ExerciseDtoDao {
    @Insert
    suspend fun insertExercise(exercise: ExerciseDto): Long

    @Query("SELECT * FROM exercise")
    suspend fun getAllExercises(): List<ExerciseDto>

    @Query("DELETE FROM exercise WHERE id = :id")
    suspend fun deleteExerciseById(id: Long)

}
