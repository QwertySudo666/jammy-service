package com.jammy.business.facade

import com.jammy.business.adapter.ProfileRepositoryAdapter
import com.jammy.domain.Profile
import java.util.*

class ProfileFacade(private val profileRepositoryAdapter: ProfileRepositoryAdapter) {
    fun fetchAll(): List<Profile> {
        return profileRepositoryAdapter.fetchAll()
    }

    fun createProfile(profile: Profile): Profile {
        return profileRepositoryAdapter.createProfile(profile)
    }

    fun fetchProfileById(id: UUID): Profile? {
        return profileRepositoryAdapter.fetchProfileById(id)
    }

    fun updateProfile(id: UUID, profile: Profile): Profile? {
        return profileRepositoryAdapter.updateProfile(id, profile)
    }

    fun deleteProfile(id: UUID): Boolean {
        return profileRepositoryAdapter.deleteProfile(id)
    }
}