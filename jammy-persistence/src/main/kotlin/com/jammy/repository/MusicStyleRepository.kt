package com.jammy.repository

import com.jammy.MusicStyleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MusicStyleRepository : JpaRepository<MusicStyleEntity, UUID>{
    fun findByIdIn(musicStyleIds: List<UUID>): List<MusicStyleEntity>
}