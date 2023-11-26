package com.jammy.business.facade

import com.jammy.business.adapter.InstrumentRepositoryAdapter
import com.jammy.domain.Instrument
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class InstrumentFacadeTest {
    private val instrumentRepository: InstrumentRepositoryAdapter =
        Mockito.mock(InstrumentRepositoryAdapter::class.java)
    private val instrumentFacade = InstrumentFacade(instrumentRepository)
    private val guitarInstrument = Instrument(name = "Guitar")
    private val bassInstrument = Instrument(name = "Bass")
    private val drumsInstrument = Instrument(name = "DRUMS")
    private val instruments = listOf(guitarInstrument, bassInstrument, drumsInstrument)

    @Test
    fun saveInstrument() {
        Mockito.`when`(instrumentRepository.saveInstrument(guitarInstrument)).thenReturn(guitarInstrument)
        val savedInstrument = instrumentFacade.saveInstrument(guitarInstrument)
        Assertions.assertEquals(guitarInstrument, savedInstrument)
    }

    @Test
    fun fetchAllInstruments() {
        Mockito.`when`(instrumentRepository.fetchAllInstruments()).thenReturn(instruments)
        val fetchedInstruments = instrumentFacade.fetchAllInstruments()
        Assertions.assertEquals(instruments, fetchedInstruments)
    }
}