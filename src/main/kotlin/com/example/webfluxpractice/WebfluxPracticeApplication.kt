package com.example.webfluxpractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.blockhound.BlockHound

@SpringBootApplication
class WebfluxPracticeApplication

fun main(args: Array<String>) {
//    BlockHound.install()
    runApplication<WebfluxPracticeApplication>(*args)
}
