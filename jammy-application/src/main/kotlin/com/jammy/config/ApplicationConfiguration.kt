package com.jammy.config

import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.business.facade.UserFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun userFacade(userRepository: UserRepositoryAdapter): UserFacade {
        return UserFacade(userRepository)
    }
}