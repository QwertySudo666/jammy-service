package com.jammy.web

import com.jammy.business.facade.ProfileFacade
import com.jammy.business.facade.UserFacade
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/init")
class InitResource(
    private val userFacade: UserFacade,
    private val profileFacade: ProfileFacade
) {
    @PostMapping()
    fun initDb(){
        val users = userFacade.initUsers()
//        val instruments = instrumentFacade.initInstruments()
//        val musicStyles = musicStyleFacade.initMusicStyles()
        val profiles = profileFacade.initProfiles(users)
    }
}