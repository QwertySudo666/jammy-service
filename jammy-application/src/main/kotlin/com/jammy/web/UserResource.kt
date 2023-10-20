package com.jammy.web

import com.jammy.business.facade.UserFacade
import com.jammy.dtos.UserDTO
import com.jammy.toDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserResource(private val userFacade: UserFacade) {
    @PostMapping("init")
    fun initUsers(){
        userFacade.initUsers()
    }

    @GetMapping
    fun fetchAll(): List<UserDTO> {
        return userFacade.fetchAll().map { it.toDTO() }
    }
}