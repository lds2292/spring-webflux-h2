package com.example.webfluxpractice.configuration

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Profile("h2")
@Configuration
@EnableR2dbcAuditing
class H2R2dbcConfig{
    @Bean
    fun h2DBInit(connectionFactory : ConnectionFactory) : ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        val resourceDatabasePopulator = ResourceDatabasePopulator()
            .apply {
                addScript(ClassPathResource("schema-users-h2.sql"))
                addScript(ClassPathResource("schema-boards-h2.sql"))
            }
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(resourceDatabasePopulator)
        return initializer
    }
}