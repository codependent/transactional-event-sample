package com.codependent.sample.service

import com.codependent.sample.domain.Billing
import com.codependent.sample.event.UserCreatedEvent
import com.codependent.sample.repository.BillingRepository
import com.codependent.sample.repository.UserRepository
import com.codependent.sample.service.exception.UserDoesntExistException
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono

@Service
class BillingServiceImpl(private val userRepository: UserRepository,
                         private val billingRepository: BillingRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener
    @Transactional
    fun userCreated(event: UserCreatedEvent): Mono<Billing> {
        logger.info("userCreated({})", event)
        return userRepository.findById(event.user.id!!)
                .switchIfEmpty {
                    UserDoesntExistException(event.user.id!!).toMono()
                }.flatMap {
                    logger.info("*** CREATING BILLING for user {}", it)
                    billingRepository.save(Billing(null, event.user.id!!))
                }
    }

}
