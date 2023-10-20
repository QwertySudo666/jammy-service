package com.jammy.business.adapter

import com.jammy.domain.User

interface UserRepositoryAdapter {
    fun fetchAll(): List<User>
    fun initUsers(usersToInit: List<User>): List<User>
}