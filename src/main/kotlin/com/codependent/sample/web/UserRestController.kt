package com.codependent.sample.web

import com.codependent.sample.domain.User
import com.codependent.sample.service.UserService
import com.codependent.sample.web.dto.UserCreate
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/users")
class UserRestController(private val userService: UserService) {

    @PostMapping
    fun create(@RequestBody user: UserCreate) = userService.create(User(null, user.name))

    @GetMapping
    fun get() : Flux<User> = userService.getAll()

}
