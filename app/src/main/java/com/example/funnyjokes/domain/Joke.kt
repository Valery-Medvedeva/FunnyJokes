package com.example.funnyjokes.domain

import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("id")
    val id: Int,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("punchline")
    val punchline: String
){
    override fun toString(): String {
        return String.format("%s\n\n%s",setup, punchline)
    }
}