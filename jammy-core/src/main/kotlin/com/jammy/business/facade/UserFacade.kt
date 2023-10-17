package com.jammy.business.facade

import com.jammy.business.adapter.UserRepositoryAdapter

class UserFacade(private val userRepository: UserRepositoryAdapter) {
}