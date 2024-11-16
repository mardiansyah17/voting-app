package com.example.votingapp.core.data.repositories

import com.example.votingapp.arch.data.Repository
import com.example.votingapp.arch.extensions.mapSuccess
import com.example.votingapp.arch.extensions.repoCall
import com.example.votingapp.core.data.network.Api
import com.example.votingapp.core.data.network.dtos.toUser
import com.example.votingapp.core.data.network.responses.TokenResponse
import com.example.votingapp.core.data.storage.UserPreferenceStore
import com.example.votingapp.core.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: Api,
    private val userPreferenceStore: UserPreferenceStore
) : Repository() {

    suspend fun login(email: String, password: String): TokenResponse = repoCall {
        api.postLogin(email, password)
    }

    suspend fun register(email: String,name:String, password: String): TokenResponse = repoCall {
        api.postLogin(email, password)
    }

    suspend fun getUser(): User {
        return api.getUser()
            .mapSuccess {
                it.data.toUser()
            }.also {
                userPreferenceStore.add(it)
            }
    }
}