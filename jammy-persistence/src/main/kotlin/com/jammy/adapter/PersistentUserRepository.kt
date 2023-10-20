package com.jammy.adapter

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.domain.User
import com.jammy.repository.UserRepository
import com.jammy.toBusinessModel
import com.jammy.toEntity
import org.springframework.stereotype.Service

@Service
class PersistentUserRepository(private val userRepository: UserRepository) : UserRepositoryAdapter {
    override fun fetchAll(): List<User> {
        return userRepository.findAll().map { it.toBusinessModel() }
    }

    override fun initUsers(usersToInit: List<User>): List<User> {
        val usersEntities = usersToInit.map { it.toEntity() }
        val persistedUsers = userRepository.saveAll(usersEntities).map { it.toBusinessModel() }
        return persistedUsers
    }
}