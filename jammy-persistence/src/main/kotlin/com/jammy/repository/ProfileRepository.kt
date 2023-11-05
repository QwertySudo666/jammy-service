package com.jammy.repository

import com.jammy.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProfileRepository : JpaRepository<ProfileEntity, UUID> {
}