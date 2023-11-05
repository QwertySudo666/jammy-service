package com.jammy

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
        id = this.id,
        email = this.email,
        username = this.username,
        password = this.password
    )
}

fun ProfileEntity.toBusinessModel(): Profile {
    return Profile(
        id = this.id,
        userId = this.userId,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}

fun Profile.toEntity(): ProfileEntity {
    return ProfileEntity(
        id = this.id,
        userId = this.userId,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}