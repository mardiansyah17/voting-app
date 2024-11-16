package com.example.votingapp.core.data.repositories

import com.example.votingapp.arch.data.Repository
import com.example.votingapp.arch.extensions.mapSuccess
import com.example.votingapp.core.data.network.Api
import com.example.votingapp.core.data.network.dtos.toEntity
import com.example.votingapp.core.data.storage.PostPreferenceStore
import com.example.votingapp.core.domain.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: Api,
    private val postPreferenceStore: PostPreferenceStore
) : Repository() {

    suspend fun getPosts(): List<Post> {
        return api.getPosts()
            .mapSuccess { list -> list.map { it.toEntity() } }
            .also { postPreferenceStore.addAll(it) }
    }
}