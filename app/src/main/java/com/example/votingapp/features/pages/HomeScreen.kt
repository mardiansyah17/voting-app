package com.example.votingapp.features.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.votingapp.core.ui.AppButton

@Composable
fun HomeRoute(
    navigateToCreateVoting: () -> Unit = {},
    navigateToJoinVoting: () -> Unit = {}
) {
    HomeScreen(
        onCreateVotingClick = navigateToCreateVoting,
        onJoinVotingClick = navigateToJoinVoting
    )
}

@Composable
fun HomeScreen(
    onCreateVotingClick: () -> Unit,
    onJoinVotingClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AppButton(
            text = stringResource(id = com.example.votingapp.R.string.join_voting),
            onClick = onJoinVotingClick
        )
        Spacer(modifier = Modifier.height(40.dp))
        AppButton(
            text = stringResource(id = com.example.votingapp.R.string.create_voting),
            onClick = onCreateVotingClick
        )
    }
}

