package com.example.votingapp.core.data.network.dtos

import com.example.votingapp.core.domain.model.Post

fun PostDto.toEntity(): Post {
    return Post(
        id = id,
        title = title,
        body = body
    )
}