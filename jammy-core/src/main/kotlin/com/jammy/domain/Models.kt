package com.jammy.domain

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
)