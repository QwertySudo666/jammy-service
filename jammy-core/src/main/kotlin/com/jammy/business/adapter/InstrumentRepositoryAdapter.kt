package com.jammy.business.adapter

import com.jammy.domain.Instrument

interface InstrumentRepositoryAdapter {
    fun saveInstrument(instrument: Instrument): Instrument
    fun fetchAllInstruments(): List<Instrument>

}