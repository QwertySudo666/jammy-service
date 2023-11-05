package com.jammy.web

import com.jammy.business.facade.ProfileFacade
import com.jammy.domain.Profile
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/profiles")
class ProfileResource(private val profileFacade: ProfileFacade) {
    @GetMapping
    fun fetchAll(): List<Profile> {
        return profileFacade.fetchAll()
    }

    @GetMapping("search")
    fun search(): List<Profile>{
        return profileFacade.fetchAll() //replace on search with filters
    }

    @PostMapping
    fun createProfile(@RequestBody profile: Profile): Profile {
        return profileFacade.createProfile(profile)
    }

    @GetMapping("{id}")
    fun getProfileById(@PathVariable id: UUID): Profile {
        return profileFacade.fetchProfileById(id)!!
    }

    @PutMapping("{id}")
    fun updateProfile(@PathVariable id: UUID, @RequestBody profile: Profile): Profile {
        return profileFacade.updateProfile(id, profile)!!
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: UUID): Boolean {
        return profileFacade.deleteProfile(id)
    }
}