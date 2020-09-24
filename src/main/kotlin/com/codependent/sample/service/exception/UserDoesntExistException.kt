package com.codependent.sample.service.exception

class UserDoesntExistException(val userId: String) : RuntimeException()
