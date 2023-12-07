package com.jammy.web

import com.jammy.business.facade.MusicStyleFacade
import com.jammy.domain.MusicStyle
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/music-styles")
class MusicStyleResource(private val musicStyleFacade: MusicStyleFacade) {
    @GetMapping
    fun fetchAll(): List<MusicStyle> {
        return musicStyleFacade.fetchAllMusicStyles()
    }

    @PostMapping
    fun save(@RequestBody genre: MusicStyle): MusicStyle {
        return musicStyleFacade.saveMusicStyle(genre)
    }
}