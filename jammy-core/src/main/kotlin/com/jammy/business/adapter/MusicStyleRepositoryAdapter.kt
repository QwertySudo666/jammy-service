package com.jammy.business.adapter

import com.jammy.domain.MusicStyle

interface MusicStyleRepositoryAdapter {
    fun fetchAll(): List<MusicStyle>
    fun saveMusicStyle(musicStyle: MusicStyle): MusicStyle
}