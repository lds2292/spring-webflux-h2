package com.example.webfluxpractice

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping("user")
@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun findAll() : Flux<User> {
        return userService.findAll();
    }

    @GetMapping("mono/error")
    fun errorMono() : Mono<User> {
        return Mono.error(RuntimeException("런타임 익셉션"))
    }

    @GetMapping("flux/error")
    fun errorFlux() : Flux<User> {
        return Flux.error(RuntimeException("런타임 익셉션"))
    }

    // 테스트
    @PostMapping
    fun save() : Mono<User> {
        val user = User("테스트", 38)
        return userService.save(user)
    }

//    @PostMapping("all")
//    fun saveAll(
//        @RequestBody list : Flux<User>) : Mono<List<User>> {
//        return userService.saveAll(list.log()).collectList()
//    }

    @PostMapping("all")
    fun saveAll(
        @RequestBody list : Flux<User>) : Flux<User> {
        return userService.saveAll(list.log())
    }
}