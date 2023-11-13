package com.jammy

import com.jammy.domain.Experience
import jakarta.persistence.*
import java.io.Serializable
import java.util.*


@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    val id: UUID,
    val email: String,
    val username: String,
    val password: String,
)

@Entity
@Table(name = "profiles")
data class ProfileEntity(
    @Id
    val id: UUID,
    val userId: UUID,
    @OneToMany
    val instruments: List<ProfileInstrumentKey>,
    @OneToMany
    val musicStyles: List<ProfileMusicStyleKey>,
    @Enumerated(EnumType.STRING)
    val experience: Experience,
    val location: String,
)

@Entity
@Table(name = "instruments")
data class InstrumentEntity(
    @Id
    val id: UUID,
    val name: String,
)

@Entity
@Table(name = "music_styles")
data class MusicStyleEntity(
    @Id
    val id: UUID,
    val name: String,
)

class ProfileInstrumentId : Serializable {
    val profileId: UUID? = null
    val instrumentId: UUID? = null
}

@Entity
@Table(name = "profile_instrument_key")
@IdClass(ProfileInstrumentId::class)
class ProfileInstrumentKey(
    @Id
    val profileId: UUID,
    @Id
    val instrumentId: UUID,
)

class ProfileMusicStyleId : Serializable {
    val profileId: UUID? = null
    val musicStyleId: UUID? = null
}

@Entity
@Table(name = "profile_music_style_key")
@IdClass(ProfileMusicStyleId::class)
class ProfileMusicStyleKey(
    @Id
    val profileId: UUID,
    @Id
    val musicStyleId: UUID,
)