package com.jammy.business.facade

import com.jammy.business.adapter.MusicStyleRepositoryAdapter
import com.jammy.domain.MusicStyle

class MusicStyleFacade(private val musicStyleRepositoryAdapter: MusicStyleRepositoryAdapter) {
    fun fetchAllMusicStyles(): List<MusicStyle> {
        return musicStyleRepositoryAdapter.fetchAll()
    }

    fun saveMusicStyle(musicStyle: MusicStyle): MusicStyle {
        return musicStyleRepositoryAdapter.saveMusicStyle(musicStyle)
    }
}