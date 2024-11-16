package com.example.votingapp.core.usecases.user

import com.example.votingapp.arch.extensions.useCaseFlow
import com.example.votingapp.core.data.repositories.UserRepository
import com.example.votingapp.injection.qualifiers.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    fun register(email: String, name: String, password: String) =
        useCaseFlow(coroutineDispatcher) {
            userRepository.register(email, name, password)
            userRepository.getUser()
        }

}