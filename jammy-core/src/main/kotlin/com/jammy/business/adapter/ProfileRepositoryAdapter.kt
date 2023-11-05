package com.jammy.business.adapter

import com.jammy.domain.Profile
import java.util.*

interface ProfileRepositoryAdapter {
    fun fetchAll(): List<Profile>
//    fun initUsers(usersToInit: List<User>): List<User>
    fun createProfile(profile: Profile): Profile
    fun fetchProfileById(id: UUID): Profile
    fun updateProfile(id: UUID, updatedProfile: Profile): Profile
    fun deleteProfile(id: UUID): Boolean
}