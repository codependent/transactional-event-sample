package com.codependent.sample.service

import com.codependent.sample.domain.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {

    fun create(user: User): Mono<User>
    fun getAll() : Flux<User>

}
