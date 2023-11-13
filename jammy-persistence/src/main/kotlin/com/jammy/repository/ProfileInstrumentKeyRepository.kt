package com.jammy.repository

import com.jammy.ProfileInstrumentKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProfileInstrumentKeyRepository : JpaRepository<ProfileInstrumentKey, UUID> {
}