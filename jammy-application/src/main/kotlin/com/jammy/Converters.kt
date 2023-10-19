package com.jammy

import com.jammy.domain.User
import com.jammy.dtos.UserDTO

fun UserDTO.toBusinessModel(): User {
    return User(
        id = this.id,
        name = this.name,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}

fun User.toDTO(): UserDTO {
    return UserDTO(
        id = this.id,
        name = this.name,
        instruments = this.instruments,
        musicStyles = this.musicStyles,
        experience = this.experience,
        location = this.location
    )
}