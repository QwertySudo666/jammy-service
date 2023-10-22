package com.jammy.business.facade

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.domain.User
import java.util.*

class UserFacade(private val userRepository: UserRepositoryAdapter) {
    fun initUsers(): List<User> {
        val usersToInit = listOf(
            User(UUID.randomUUID(), "ivan@gmail.com", "1van1dze", "pass"),
            User(UUID.randomUUID(), "taras@gmail.com", "tar1k", "pass"),
            User(UUID.randomUUID(), "slava@gmail.com", "slavaukr", "pass"),
        )
        return userRepository.initUsers(usersToInit)
    }

    fun fetchAll(): List<User> {
        return userRepository.fetchAll()
    }

    fun createUser(user: User): User {
        // Implement the logic to create a new user in your repository
        // For example:
        return userRepository.createUser(user)
    }

    fun fetchUserById(id: UUID): User? {
        // Implement the logic to fetch a user by their ID from your repository
        // For example:
        return userRepository.fetchUserById(id)
    }

    fun updateUser(id: UUID, user: User): User? {
        // Implement the logic to update a user with the given ID in your repository
        // For example:
        val existingUser = userRepository.fetchUserById(id)
        if (existingUser != null) {
            val updatedUser = existingUser.copy(
                email = user.email,
                username = user.username,
                password = user.password
            )
            return userRepository.updateUser(id, updatedUser)
        }
        return null
    }

    fun deleteUser(id: UUID): Boolean {
        // Implement the logic to delete a user by their ID from your repository
        // For example:
        return userRepository.deleteUser(id)
    }
}