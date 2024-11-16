package com.example.votingapp.core.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.votingapp.arch.data.SharedPreferenceDataStore
import com.example.votingapp.core.domain.model.User
import javax.inject.Inject

class UserPreferenceStore @Inject constructor(
    dataStore: DataStore<Preferences>
) : SharedPreferenceDataStore<User>(dataStore, User.serializer())