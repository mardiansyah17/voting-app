package com.example.votingapp.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.votingapp.arch.extensions.collectAsStateLifecycleAware
import com.example.votingapp.core.ui.AppButton
import com.example.votingapp.core.ui.InputPassword
import com.example.votingapp.core.ui.InputTextField


@Composable
internal fun LoginRoute(

    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit = {},
    navigateToRegister: () -> Unit = {}
) {
    val loginUiInfo = viewModel.loginUiInfo.collectAsStateLifecycleAware().value
    LoginScreen(
        viewModel = viewModel,
        login = viewModel::login,
        navigateToHome = navigateToHome,
        navigateToRegister = navigateToRegister,
        loginInfo = loginUiInfo
    )
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    login: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToRegister: () -> Unit,
    loginInfo: LoginUiInfo
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        InputTextField(text = loginInfo.email, label = "Email") {
            viewModel.onUserEmailChanged(it)
        }
        Spacer(modifier = Modifier.height(10.dp))

        InputPassword(
            passwordVisible = viewModel.passwordVisible.value,
            value = loginInfo.password,
            togglePasswordVisibility = viewModel::onPasswordVisibilityChanged,

            ) {
            viewModel.onPasswordChanged(it)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Lupa Password?", color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(10.dp))
        AppButton(text = stringResource(id = com.example.votingapp.R.string.login)) {


        }
        Spacer(modifier = Modifier.height(10.dp))
        RegisterText(
            onRegisterClick = {
                navigateToRegister()
            }
        )
    }

}

@Composable
fun RegisterText(onRegisterClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        append("Belum punya akun? ")
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "register",
                linkInteractionListener = { offset ->
                    onRegisterClick()
                },
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        ) {
            append("Daftar")
        }
    }

    BasicText(text = annotatedString)

}


