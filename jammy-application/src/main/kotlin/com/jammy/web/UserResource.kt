package com.jammy.web

import com.jammy.business.facade.UserFacade
import com.jammy.dtos.UserDTO
import com.jammy.toBusinessModel
import com.jammy.toDTO
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
    fun fetchAll(): List<UserDTO> {
        return userFacade.fetchAll().map { it.toDTO() }
    }

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): UserDTO {
        return userFacade.createUser(userDTO.toBusinessModel()).toDTO()
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: UUID): UserDTO {
        return userFacade.fetchUserById(id)!!.toDTO()
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: UUID, @RequestBody userDTO: UserDTO): UserDTO? {
        return userFacade.updateUser(id, userDTO.toBusinessModel())?.toDTO()
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: UUID): Boolean {
        return userFacade.deleteUser(id)
    }
}