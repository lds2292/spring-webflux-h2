package com.example.webfluxpractice.configuration

import org.h2.tools.Server
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener

@Profile("h2")
@Configuration
class H2ConsoleConfig {
    private lateinit var webServer : Server

    @Value("\${h2-console.port}")
    private val port : String = "8080"

    private val log = LoggerFactory.getLogger(this::class.java)

    @EventListener(ContextRefreshedEvent::class)
    fun start() {
        log.info("start h2 console port:$port")
        this.webServer = Server.createWebServer(
            "-webPort",
            port,
            "-tcpAllowOthers"
        ).start()
    }

    @EventListener(ContextClosedEvent::class)
    fun stop(){
        this.webServer.stop()
    }
}

