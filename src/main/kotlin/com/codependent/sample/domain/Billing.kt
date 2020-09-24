package com.codependent.sample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sample-billing")
data class Billing (@Id var id: String?, var userId: String)
