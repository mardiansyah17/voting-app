package com.example.votingapp.core.data.network.responses

import com.example.votingapp.core.data.network.dtos.ResourceDto
import kotlinx.serialization.Serializable

@Serializable
data class ResourcesResponse(
    val data: List<ResourceDto>
)