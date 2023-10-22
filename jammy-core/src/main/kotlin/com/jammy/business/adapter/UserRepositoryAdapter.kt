package com.jammy.business.adapter

import com.jammy.domain.User
import java.util.*

interface UserRepositoryAdapter {
    fun fetchAll(): List<User>
    fun initUsers(usersToInit: List<User>): List<User>
    fun createUser(user: User): User
    fun fetchUserById(id: UUID): User?
    fun updateUser(id: UUID, updatedUser: User): User?
    fun deleteUser(id: UUID): Boolean
}