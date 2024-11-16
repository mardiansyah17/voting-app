package com.example.votingapp.core.data.network.responses

import com.example.votingapp.core.data.network.dtos.UserDto
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val data: UserDto
)