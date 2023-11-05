package com.jammy.web

import com.jammy.business.facade.UserFacade
import com.jammy.domain.User
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/users")
class UserResource(private val userFacade: UserFacade) {
    @PostMapping("init")
    fun initUsers() {
        userFacade.initUsers()
    }

    @GetMapping
    fun fetchAll(): List<User> {
        return userFacade.fetchAll()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userFacade.createUser(user)
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: UUID): User {
        return userFacade.fetchUserById(id)!!
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: UUID, @RequestBody user: User): User {
        return userFacade.updateUser(id, user)!!
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: UUID): Boolean {
        return userFacade.deleteUser(id)
    }
}