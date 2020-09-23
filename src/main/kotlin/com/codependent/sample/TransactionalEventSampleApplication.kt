package com.codependent.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransactionalEventSampleApplication

fun main(args: Array<String>) {
    runApplication<TransactionalEventSampleApplication>(*args)
}
