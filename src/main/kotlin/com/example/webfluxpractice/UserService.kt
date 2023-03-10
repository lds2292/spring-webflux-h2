package com.example.webfluxpractice

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {

    fun save(user : User) : Mono<User> {
        return userRepository.save(user)
    }

    fun saveAll(users : Flux<User>) : Flux<User> {
        return userRepository.saveAll(users)
    }

    fun findAll(): Flux<User> {
        return userRepository.findAll()
    }
}