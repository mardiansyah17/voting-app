package com.example.votingapp.core.data.network.dtos

import com.example.votingapp.core.domain.model.User

fun UserDto.toUser(): User {
    return User(
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}