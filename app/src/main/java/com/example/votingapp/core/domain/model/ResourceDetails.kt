package com.example.votingapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResourceDetails(
    val name: String,
    val imageUrl: String
) : Parcelable