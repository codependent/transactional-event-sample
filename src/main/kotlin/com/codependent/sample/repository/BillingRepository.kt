package com.codependent.sample.repository

import com.codependent.sample.domain.Billing
import com.codependent.sample.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface BillingRepository: ReactiveMongoRepository<Billing, String>
