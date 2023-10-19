package com.jammy.web

import com.jammy.business.facade.UserFacade
import com.jammy.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserResource(private val userFacade: UserFacade) {
    @GetMapping
    fun fetchAll(): List<User>{
        return userFacade.fetchAll()
    }
}