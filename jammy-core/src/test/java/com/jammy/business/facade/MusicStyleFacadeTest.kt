package com.jammy.business.facade

import com.jammy.business.adapter.InstrumentRepositoryAdapter
import com.jammy.business.adapter.MusicStyleRepositoryAdapter
import com.jammy.domain.Instrument
import com.jammy.domain.MusicStyle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class MusicStyleFacadeTest {
    private val musicStyleRepositoryAdapter: MusicStyleRepositoryAdapter =
        Mockito.mock(MusicStyleRepositoryAdapter::class.java)
    private val musicStyleFacade = MusicStyleFacade(musicStyleRepositoryAdapter)
    private val metalGenre = MusicStyle(name = "Metal")
    private val rockGenre = MusicStyle(name = "Rock")
    private val popGenre = MusicStyle(name = "Pop")
    private val classicalGenre = MusicStyle(name = "Classical")
    private val genres = listOf(
        metalGenre,
        rockGenre,
        popGenre,
        classicalGenre,
    )

    @Test
    fun fetchAllMusicStyles() {
        Mockito.`when`(musicStyleRepositoryAdapter.fetchAll()).thenReturn(genres)
        val fetchedGenres = musicStyleFacade.fetchAllMusicStyles()
        assertEquals(genres, fetchedGenres)
    }

    @Test
    fun saveMusicStyle() {
        Mockito.`when`(musicStyleRepositoryAdapter.saveMusicStyle(metalGenre)).thenReturn(metalGenre)
        val savedGenre = musicStyleFacade.saveMusicStyle(metalGenre)
        assertEquals(metalGenre, savedGenre)
    }
}