package com.jammy.adapter

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.domain.User
import com.jammy.repository.UserRepository
import com.jammy.toBusinessModel
import com.jammy.toEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersistentUserRepository(private val userRepository: UserRepository) : UserRepositoryAdapter {
    override fun fetchAll(): List<User> {
        return userRepository.findAll().map { it.toBusinessModel() }
    }

    override fun initUsers(usersToInit: List<User>): List<User> {
        val usersEntities = usersToInit.map { it.toEntity() }
        return userRepository.saveAll(usersEntities).map { it.toBusinessModel() }
    }

    override fun createUser(user: User): User {
        val userEntity = user.toEntity()
        val savedEntity = userRepository.save(userEntity)
        return savedEntity.toBusinessModel()
    }

    override fun fetchUserById(id: UUID): User? {
        val userEntity = userRepository.findById(id)
        return userEntity.map { it.toBusinessModel() }.orElse(null)
    }

    override fun updateUser(id: UUID, updatedUser: User): User? {
        val existingUserEntity = userRepository.findById(id)
        if (existingUserEntity.isPresent) {
            val updatedUserEntity = existingUserEntity.get().copy(
                email = updatedUser.email,
                username = updatedUser.username,
                password = updatedUser.password
            )
            val savedEntity = userRepository.save(updatedUserEntity)
            return savedEntity.toBusinessModel()
        }
        return null
    }

    override fun deleteUser(id: UUID): Boolean {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            return true
        }
        return false
    }
}