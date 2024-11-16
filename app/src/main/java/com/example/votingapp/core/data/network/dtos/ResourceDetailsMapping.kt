package com.example.votingapp.core.data.network.dtos

import com.example.votingapp.core.domain.model.ResourceDetails

fun ResourceDetailsDto.toEntity(): ResourceDetails {
    return ResourceDetails(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}