package com.jammy.business.facade

import com.jammy.business.adapter.ProfileRepositoryAdapter
import com.jammy.domain.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ProfileFacadeTest {
    private val user = User(
        email = "john.doe@gmail.com",
        username = "jDoe",
        password = "pass"
    )
    private val persistedUsers = listOf(
        user,
        User(email = "harry.potter@gmail,com", username = "Potter", password = "pass"),
        User(email = "Harald Haraldson", username = "HH", password = "pass"),
    )
    private val instruments = listOf(Instrument(name = "Guitar"))
    private val genres = listOf(MusicStyle(name = "Metal"))
    private val profile = Profile(
        userId = user.id,
        instrumentIds = instruments.map { it.id },
        musicStyleIds = genres.map { it.id },
        experience = Experience.GOOD,
        location = "Tokyo",
    )
    private val profiles = listOf(profile)

    private val profileRepositoryAdapter: ProfileRepositoryAdapter = Mockito.mock(ProfileRepositoryAdapter::class.java)
    private val profileFacade = ProfileFacade(profileRepositoryAdapter)

    @Test
    fun createProfile() {
        Mockito.`when`(profileRepositoryAdapter.createProfile(profile)).thenReturn(profile)
        val createdProfile = profileFacade.createProfile(profile)
        assertEquals(profile, createdProfile)
    }

    @Test
    fun fetchProfileById() {
        Mockito.`when`(profileRepositoryAdapter.fetchProfileById(profile.id)).thenReturn(profile)
        val fetchedProfile = profileFacade.fetchProfileById(profile.id)
        assertEquals(profile, fetchedProfile)
    }

    @Test
    fun updateProfile() {
        Mockito.`when`(profileRepositoryAdapter.updateProfile(profile.id, profile)).thenReturn(profile)
        val updatedProfile = profileFacade.updateProfile(profile.id, profile)
        assertEquals(profile, updatedProfile)
    }

    @Test
    fun deleteProfile_ifUserExists_true() {
        Mockito.`when`(profileRepositoryAdapter.deleteProfile(profile.id)).thenReturn(true)
        val deleted = profileFacade.deleteProfile(profile.id)
        assertTrue(deleted)
    }

    @Test
    fun deleteProfile_ifUserDoesntExists_true() {
        Mockito.`when`(profileRepositoryAdapter.deleteProfile(profile.id)).thenReturn(false)
        val deleted = profileFacade.deleteProfile(profile.id)
        assertFalse(deleted)
    }

    @Test
    fun fetchAll() {
        Mockito.`when`(profileRepositoryAdapter.fetchAll()).thenReturn(profiles)
        val fetchedProfiles = profileFacade.fetchAll()
        assertEquals(profiles, fetchedProfiles)
    }

    @Test
    fun initProfiles() {
    }
}