package com.jammy

import com.jammy.domain.Experience
import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    val id: UUID,
    val name: String,
    val instruments: List<Instrument>,
    val musicStyles: List<MusicStyle>,
    val experience: Experience,
    val location: String,
)