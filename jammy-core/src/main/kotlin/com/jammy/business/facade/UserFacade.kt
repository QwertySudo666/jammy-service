package com.jammy.business.facade

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.domain.User

class UserFacade(private val userRepository: UserRepositoryAdapter) {
    fun fetchAll(): List<User> {
        return userRepository.fetchAll()
    }
}