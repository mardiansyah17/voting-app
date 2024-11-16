package com.example.votingapp.features.register

import androidx.lifecycle.ViewModel
import com.example.votingapp.arch.extensions.LoadingAware
import com.example.votingapp.arch.extensions.ViewErrorAware
import com.example.votingapp.core.usecases.user.RegisterUseCase
import com.example.votingapp.features.login.LoginUiInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
    val loginUiInfo by lazy {
        MutableStateFlow(
            LoginUiInfo("", "")
        )
    }

}