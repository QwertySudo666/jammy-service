package com.jammy.adapter

import com.jammy.business.adapter.MusicStyleRepositoryAdapter
import com.jammy.domain.MusicStyle
import com.jammy.repository.MusicStyleRepository
import com.jammy.toBusinessModel
import com.jammy.toEntity
import org.springframework.stereotype.Service

@Service
class PersistentMusicStyleRepository(private val musicStyleRepository: MusicStyleRepository) :
    MusicStyleRepositoryAdapter {
    override fun fetchAll(): List<MusicStyle> {
        return musicStyleRepository.findAll().map { it.toBusinessModel() }
    }

    override fun saveMusicStyle(musicStyle: MusicStyle): MusicStyle {
        return musicStyleRepository.save(musicStyle.toEntity()).toBusinessModel()
    }
}