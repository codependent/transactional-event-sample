package com.codependent.sample.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.ReactiveMongoTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@Configuration
class MongoDbConfiguration {

    @Bean
    fun mongoTransactionManager(dbFactory: ReactiveMongoDatabaseFactory) =
            ReactiveMongoTransactionManager(dbFactory)

}
