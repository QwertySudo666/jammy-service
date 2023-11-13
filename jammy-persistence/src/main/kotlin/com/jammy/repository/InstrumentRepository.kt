package com.jammy.repository

import com.jammy.InstrumentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InstrumentRepository : JpaRepository<InstrumentEntity, UUID> {
    fun findByIdIn(id: List<UUID>): List<InstrumentEntity>
}