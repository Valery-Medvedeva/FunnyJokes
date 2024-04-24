package com.example.funnyjokes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeDb (
    @PrimaryKey
    val id: Int,
    val setup: String,
    val punchline: String
){
    override fun toString(): String {
        return String.format("%s\n\n%s",setup, punchline)
    }
}