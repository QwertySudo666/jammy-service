package com.jammy

import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import com.jammy.domain.Profile
import com.jammy.domain.User

fun UserEntity.toBusinessModel(): User {
    return User(
        id = this.id,
        email = this.email,
        username = this.username,
        password = this.password,
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id, email = this.email, username = this.username, password = this.password
    )
}

fun ProfileEntity.toBusinessModel(): Profile {
    return Profile(
        id = this.id,
        userId = this.userId,
        instrumentIds = this.instruments.map { it.instrumentId },
        musicStyleIds = this.musicStyles.map { it.musicStyleId },
        experience = this.experience,
        location = this.location
    )
}

fun Profile.toEntity(): ProfileEntity {
    return ProfileEntity(
        id = this.id,
        userId = this.userId,
        instruments = this.instrumentIds.map { ProfileInstrumentKey(this.id, it) },
        musicStyles = this.musicStyleIds.map { ProfileMusicStyleKey(this.id, it) },
        experience = this.experience,
        location = this.location
    )
}

fun InstrumentEntity.toBusinessModel(): Instrument {
    return Instrument(
        this.id, this.name
    )
}

fun Instrument.toEntity(): InstrumentEntity {
    return InstrumentEntity(
        this.id, this.name
    )
}

fun MusicStyleEntity.toBusinessModel(): MusicStyle {
    return MusicStyle(
        this.id, this.name
    )
}

fun MusicStyle.toEntity(): MusicStyleEntity {
    return MusicStyleEntity(
        this.id, this.name
    )
}