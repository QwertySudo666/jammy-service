package com.jammy

import com.jammy.domain.User

fun UserEntity.toBusinessModel(): User {
    return User(this.id)
}

fun User.toEntity(): UserEntity {
    return UserEntity(this.id)
}