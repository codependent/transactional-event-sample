package com.codependent.sample.service

import com.codependent.sample.domain.User
import com.codependent.sample.event.UserCreatedEvent
import com.codependent.sample.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
@Transactional
class UserServiceImpl(private val userRepository: UserRepository,
                      private val applicationEventPublisher: ApplicationEventPublisher) : UserService {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun create(user: User): Mono<User> {
        logger.info("create() isSyncActive {} - isTxActive {}",
                TransactionSynchronizationManager.isSynchronizationActive(),
                TransactionSynchronizationManager.isActualTransactionActive())
        return userRepository.save(user)
                .flatMap {
                    applicationEventPublisher.publishEvent(UserCreatedEvent(it))
                    it.toMono()
                }
    }

    override fun getAll(): Flux<User> {
        return userRepository.findAll()
    }
}
