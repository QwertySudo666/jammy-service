package com.jammy

import com.jammy.domain.User

fun UserEntity.toBusinessModel(): User {
    return User(
        id = this.id,
        name = this.name,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}