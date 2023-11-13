package com.jammy.domain

import java.util.*

data class User(
    val id: UUID = UUID.randomUUID(),
    val email: String,
    val username: String,
    val password: String,
)

data class Profile(
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val instrumentIds: List<UUID>,
    val musicStyleIds: List<UUID>,
    val experience: Experience,
    val location: String,
)

data class Instrument(
    val id: UUID = UUID.randomUUID(),
    val name: String,
)

data class MusicStyle(
    val id: UUID = UUID.randomUUID(),
    val name: String,
)

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