package com.jammy.adapter

import com.jammy.business.adapter.InstrumentRepositoryAdapter
import com.jammy.domain.Instrument
import com.jammy.repository.InstrumentRepository
import com.jammy.toBusinessModel
import com.jammy.toEntity
import org.springframework.stereotype.Service

@Service
class PersistentInstrumentRepository(private val instrumentRepository: InstrumentRepository) :
    InstrumentRepositoryAdapter {
    override fun saveInstrument(instrument: Instrument): Instrument {
        return instrumentRepository.save(instrument.toEntity()).toBusinessModel()
    }

    override fun fetchAllInstruments(): List<Instrument> {
        return instrumentRepository.findAll().map { it.toBusinessModel() }
    }
}