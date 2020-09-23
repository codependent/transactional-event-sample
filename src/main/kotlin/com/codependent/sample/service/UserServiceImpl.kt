package com.codependent.sample.service

import com.codependent.sample.domain.User
import com.codependent.sample.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Transactional
    override fun create(user: User): Mono<User> {
        logger.info("create() isSyncActive {} - isTxActive {}",
                TransactionSynchronizationManager.isSynchronizationActive(),
                TransactionSynchronizationManager.isActualTransactionActive())

        return userRepository.save(user.complete())
    }

    override fun getAll(): Flux<User> {
        return userRepository.findAll()
    }
}
