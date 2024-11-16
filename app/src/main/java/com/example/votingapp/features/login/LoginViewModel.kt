package com.example.votingapp.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.bindError
import androidx.lifecycle.bindLoading
import androidx.lifecycle.viewModelScope
import com.example.votingapp.arch.extensions.LoadingAware
import com.example.votingapp.arch.extensions.ViewErrorAware
import com.example.votingapp.arch.extensions.onSuccess
import com.example.votingapp.core.usecases.user.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
    val loginUiInfo by lazy {
        MutableStateFlow(
            LoginUiInfo("", "")
        )
    }

    var passwordVisible = mutableStateOf(false)


    private val loginResultFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()


    fun login() {
        loginUseCase
            .login(loginUiInfo.value.email, loginUiInfo.value.password)
            .bindLoading(this)
            .bindError(this)
            .onSuccess {
                loginResultFlow.emit(true)
            }
            .launchIn(viewModelScope)
    }

    fun onUserEmailChanged(email: String) {
        loginUiInfo.value = loginUiInfo.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        loginUiInfo.value = loginUiInfo.value.copy(password = password)
    }

    fun onPasswordVisibilityChanged() {
        passwordVisible.value = !passwordVisible.value
    }
}

data class LoginUiInfo(
    val email: String,
    val password: String
)