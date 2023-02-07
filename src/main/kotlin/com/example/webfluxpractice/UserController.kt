package com.example.webfluxpractice

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping("user")
@RestController
class UserController(
    private val userService: UserService
) {
    // 테스트
    @PostMapping
    fun save() : Mono<User> {
        val user = User("테스트", 38)
        return userService.save(user)
    }

    @PostMapping("all")
    fun saveAll() : Flux<User> {
        val users = Flux.just(
            User("라이언", 10),
            User("제이지", 8),
            User("어피치", 11),
            User("춘식이", 5),
        ).log()
        return userService.saveAll(users)
    }
}