package com.jammy.dtos

import com.jammy.domain.Experience
import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import java.util.*

data class UserDTO(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val instruments: List<Instrument>,
    val musicStyles: List<MusicStyle>,
    val experience: Experience,
    val location: String,
)
