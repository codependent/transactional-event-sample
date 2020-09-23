package com.codependent.sample.repository

import com.codependent.sample.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository: ReactiveMongoRepository<User, String>
