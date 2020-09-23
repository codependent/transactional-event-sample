package com.codependent.sample.domain

import com.codependent.sample.event.UserCreatedEvent
import org.springframework.data.domain.AbstractAggregateRoot
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sample-user")
data class User (var id: String?, var name: String) : AbstractAggregateRoot<User>(){

    fun complete(): User {
        registerEvent(UserCreatedEvent(name))
        return this
    }

}
