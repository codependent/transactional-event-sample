package com.codependent.sample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sample-user")
data class User (@Id var id: String?, var name: String)
