package com.example.votingapp.core.data.network.dtos

import com.example.votingapp.core.pagination.model.Resource

fun ResourceDto.toEntity(): Resource {
    return Resource(
        id = id,
        name = name
    )
}