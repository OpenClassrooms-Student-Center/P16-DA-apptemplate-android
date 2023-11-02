package com.openclassrooms.arista.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.openclassrooms.arista.domain.model.Exercise
import com.openclassrooms.arista.domain.model.ExerciseCategory
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

@Entity(tableName = "exercise")
data class ExerciseDto(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var startTime: Long,
    var duration: Int,
    var category: String,
    var intensity: Int
) {
    fun toExercise(): Exercise {
        return Exercise(
            id,
            LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), ZoneId.systemDefault()),
            duration,
            ExerciseCategory.valueOf(category),
            intensity
        )
    }
}