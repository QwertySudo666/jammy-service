package com.jammy.business.facade

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.domain.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class UserFacadeTest {
    private val user = User(
        email = "john.doe@gmail.com",
        username = "jDoe",
        password = "pass"
    )
    private val persistedUsers = listOf(
        user,
        User(email = "harry.potter@gmail,com", username = "Potter", password = "pass"),
        User(email = "Harald Haraldson", username = "HH", password = "pass"),
    )
    private val userRepository: UserRepositoryAdapter = Mockito.mock(UserRepositoryAdapter::class.java)
    private val userFacade = UserFacade(userRepository)

    @Test
    fun fetchAll() {
        Mockito.`when`(userRepository.fetchAll()).thenReturn(persistedUsers)
        val fetchedUsers = userFacade.fetchAll()
        assertEquals(persistedUsers, fetchedUsers)
    }

    @Test
    fun createUser() {
        Mockito.`when`(userRepository.createUser(user)).thenReturn(user)
        val createdUser = userFacade.createUser(user)
        assertEquals(user, createdUser)
    }

    @Test
    fun fetchUserById() {
        Mockito.`when`(userRepository.fetchUserById(user.id)).thenReturn(user)
        val fetchedUser = userFacade.fetchUserById(user.id)
        assertEquals(user, fetchedUser)
    }

    @Test
    fun updateUser_ifUserExists_User() {
        Mockito.`when`(userRepository.updateUser(user.id, user)).thenReturn(user)
        Mockito.`when`(userRepository.fetchUserById(user.id)).thenReturn(user)
        val fetchedUser = userFacade.updateUser(user.id, user)
        assertEquals(user, fetchedUser)
    }

    @Test
    fun updateUser_ifUserDoesntExists_Null() {
        Mockito.`when`(userRepository.updateUser(user.id, user)).thenReturn(user)
        Mockito.`when`(userRepository.fetchUserById(user.id)).thenReturn(null)
        val fetchedUser = userFacade.updateUser(user.id, user)
        assertNull(fetchedUser)
    }

    @Test
    fun deleteUser_ifUserExists_true() {
        Mockito.`when`(userRepository.deleteUser(user.id)).thenReturn(true)
        val deleted = userFacade.deleteUser(user.id)
        assertTrue(deleted)
    }

    @Test
    fun deleteUser_ifUserDoesntExists_false() {
        Mockito.`when`(userRepository.deleteUser(user.id)).thenReturn(false)
        val deleted = userFacade.deleteUser(user.id)
        assertFalse(deleted)
    }
}