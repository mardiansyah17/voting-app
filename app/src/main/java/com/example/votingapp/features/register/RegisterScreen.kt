package com.example.votingapp.features.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.votingapp.core.ui.AppButton
import com.example.votingapp.core.ui.AppTheme
import com.example.votingapp.core.ui.InputTextField
import com.example.votingapp.core.ui.InputTextFieldType

@Composable
internal fun RegisterRoute(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {}
) {
    RegisterScreen(modifier, navigateToLogin)
}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        InputTextField(text = "", label = "Email") {

        }
        Spacer(modifier = Modifier.height(10.dp))

        InputTextField(text = "", label = "Nama") {

        }
        Spacer(modifier = Modifier.height(10.dp))
        InputTextField(text = "", label = "Password") {

        }

        Spacer(modifier = Modifier.height(10.dp))
        AppButton(text = stringResource(id = com.example.votingapp.R.string.register)) {
            //TODO call  login()

        }
        Spacer(modifier = Modifier.height(10.dp))
        LoginText(onRegisterClick = {
            navigateToLogin()
        })
    }
}

@Composable
fun LoginText(onRegisterClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        append("Sudah punya akun? ")
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "login",
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
            append("Masuk")
        }
    }

    BasicText(text = annotatedString)

}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    AppTheme {
        RegisterScreen()
    }
}

