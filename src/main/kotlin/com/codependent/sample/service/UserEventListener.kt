package com.codependent.sample.service

import com.codependent.sample.event.UserCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Service
class UserEventListener {

    private val logger = LoggerFactory.getLogger(javaClass)

    @TransactionalEventListener
    @Transactional
    fun userCreated(event: UserCreatedEvent){
        logger.info("userCreated({})", event)
    }

}
