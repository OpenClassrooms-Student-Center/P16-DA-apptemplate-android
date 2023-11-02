package com.openclassrooms.arista.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.openclassrooms.arista.domain.model.Sleep
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

@Entity(tableName = "sleep")
data class SleepDto(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var startTime: Long,
    var duration: Int,
    var quality: Int
) {
    fun toSleep(): Sleep {
        return Sleep(
            LocalDateTime.ofInstant(
                Instant.ofEpochMilli(startTime),
                ZoneId.systemDefault()
            ), duration, quality
        )
    }
}
