package com.jammy.web

import com.jammy.business.facade.InstrumentFacade
import com.jammy.domain.Instrument
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/instruments")
class InstrumentResource(private val instrumentFacade: InstrumentFacade) {
    @GetMapping
    fun fetchAll(): List<Instrument> {
        return instrumentFacade.fetchAllInstruments()
    }

    @PostMapping
    fun save(@RequestBody instrument: Instrument): Instrument {
        return instrumentFacade.saveInstrument(instrument)
    }
}