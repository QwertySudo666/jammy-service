package com.jammy.domain

import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val username: String,
    val password: String,
//    val instruments: List<Instrument>,
//    val musicStyles: List<MusicStyle>,
//    val experience: Experience,
//    val location: String,
)

enum class Instrument {
    BASS,
    DRUMS,
    ELECTRIC_GUITAR,
    VOCAL
}

enum class MusicStyle {
    METAL,
    ROCK,
    ALTERNATIVE
}

enum class Experience {
    BEGINNER,
    INTERMEDIATE,
    GOOD,
    ADVANCED
}

data class Message(
    val id: Int,
    val senderId: Int,
    val receiverId: Int,
    val content: String,
    val timestamp: Long,
)