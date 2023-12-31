package com.jammy.config

import com.jammy.business.adapter.InstrumentRepositoryAdapter
import com.jammy.business.adapter.MusicStyleRepositoryAdapter
import com.jammy.business.adapter.ProfileRepositoryAdapter
import com.jammy.business.adapter.UserRepositoryAdapter
import com.jammy.business.facade.InstrumentFacade
import com.jammy.business.facade.MusicStyleFacade
import com.jammy.business.facade.ProfileFacade
import com.jammy.business.facade.UserFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun userFacade(userRepository: UserRepositoryAdapter): UserFacade {
        return UserFacade(userRepository)
    }

    @Bean
    fun profileFacade(profileRepository: ProfileRepositoryAdapter): ProfileFacade {
        return ProfileFacade(profileRepository)
    }

    @Bean
    fun instrumentFacade(instrumentRepository: InstrumentRepositoryAdapter): InstrumentFacade {
        return InstrumentFacade(instrumentRepository)
    }

    @Bean
    fun musicStyleFacade(musicStyleRepository: MusicStyleRepositoryAdapter): MusicStyleFacade {
        return MusicStyleFacade(musicStyleRepository)
    }
}