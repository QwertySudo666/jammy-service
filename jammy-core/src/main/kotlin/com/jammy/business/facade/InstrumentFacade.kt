package com.jammy.business.facade

import com.jammy.business.adapter.InstrumentRepositoryAdapter
import com.jammy.domain.Instrument

class InstrumentFacade(private val instrumentFacade: InstrumentRepositoryAdapter) {
    fun saveInstrument(instrument: Instrument): Instrument{
        return instrumentFacade.saveInstrument(instrument)
    }

    fun fetchAllInstruments(): List<Instrument>{
        return instrumentFacade.fetchAllInstruments()
    }
}