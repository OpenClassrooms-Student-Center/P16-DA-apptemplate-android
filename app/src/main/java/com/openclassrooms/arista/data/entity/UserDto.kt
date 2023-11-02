package com.openclassrooms.arista.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.openclassrooms.arista.domain.model.User

@Entity(tableName = "users")
data class UserDto(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String,
    var email: String,
    var password: String
) {
    fun toUser(): User {
        return User(name, email, password)
    }
}