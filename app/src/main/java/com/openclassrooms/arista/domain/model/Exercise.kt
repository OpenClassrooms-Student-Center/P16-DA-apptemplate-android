package com.openclassrooms.arista.domain.model

import com.openclassrooms.arista.data.entity.ExerciseDto
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset

data class Exercise(
    val id: Long? = null,
    var startTime: LocalDateTime,
    var duration: Int,
    var category: ExerciseCategory,
    var intensity: Int
) {
    fun toDto(): ExerciseDto {
        return ExerciseDto(
            startTime = this.startTime.toEpochSecond(ZoneOffset.UTC), // Convert to timestamp
            duration = this.duration,
            category = this.category.name, // Convert Enum to String
            intensity = this.intensity
        )
    }
}
