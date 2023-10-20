package com.jammy.dtos

import com.jammy.domain.Experience
import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import java.util.*

data class UserDTO(
    val id: UUID = UUID.randomUUID(),
    val email: String,
    val username: String,
    val password: String,
)
