package com.jammy.adapter

import com.jammy.business.adapter.ProfileRepositoryAdapter
import com.jammy.domain.Profile
import com.jammy.repository.ProfileRepository
import com.jammy.toBusinessModel
import com.jammy.toEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersistentProfileRepository(
    private val profileRepository: ProfileRepository,
) : ProfileRepositoryAdapter {
    override fun fetchAll(): List<Profile> {
        return profileRepository.findAll().map { it.toBusinessModel() }
    }

    override fun createProfile(profile: Profile): Profile {
        return profileRepository.save(profile.toEntity()).toBusinessModel()
    }

    override fun fetchProfileById(id: UUID): Profile {
        return profileRepository.findById(id).get().toBusinessModel()
    }

    override fun updateProfile(id: UUID, updatedProfile: Profile): Profile {
        return profileRepository.save(updatedProfile.toEntity()).toBusinessModel()
    }

    override fun deleteProfile(id: UUID): Boolean {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id)
            return true
        }
        return false
    }
}