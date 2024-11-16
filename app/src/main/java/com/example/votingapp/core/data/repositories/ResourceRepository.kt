package com.example.votingapp.core.data.repositories

import com.example.votingapp.arch.data.Repository
import com.example.votingapp.arch.extensions.mapSuccess
import com.example.votingapp.core.data.network.Api
import com.example.votingapp.core.data.network.dtos.toEntity
import com.example.votingapp.core.domain.model.ResourceDetails
import com.example.votingapp.core.pagination.model.Resource
import javax.inject.Inject

class ResourceRepository @Inject constructor(
    private val api: Api,
) : Repository() {

    suspend fun getResources(page: Int, pageSize: Int): List<Resource> {
        return api.getResources(page, pageSize)
            .mapSuccess { response -> response.map { it.toEntity() } }
    }

    suspend fun getResourcesDetails(id: Int): ResourceDetails {
        return api.getResourcesDetails(id)
            .mapSuccess {
                it[0].toEntity()
            }
    }


}