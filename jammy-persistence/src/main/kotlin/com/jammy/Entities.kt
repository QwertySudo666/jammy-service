package com.jammy

import com.jammy.domain.Experience
import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import com.jammy.domain.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    val id: UUID,
    val email: String,
    val username: String,
    val password: String,
//    val instruments: List<Instrument>,
//    val musicStyles: List<MusicStyle>,
//    val experience: Experience,
//    val location: String,
)

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