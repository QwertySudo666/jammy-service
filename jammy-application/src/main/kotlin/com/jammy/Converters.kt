package com.jammy

import com.jammy.domain.User
import com.jammy.dtos.UserDTO

fun UserDTO.toBusinessModel(): User {
    return User(
        id = this.id,
        email = this.email,
        username = this.username,
        password = this.password
    )
}

fun User.toDTO(): UserDTO {
    return UserDTO(
        id = this.id,
        email = this.email,
        username = this.username,
        password = this.password
    )
}