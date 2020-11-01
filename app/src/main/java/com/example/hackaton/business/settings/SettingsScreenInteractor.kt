package com.example.hackaton.business.settings

import com.example.hackaton.data.IMainScreenRepository
import javax.inject.Inject

class SettingsScreenInteractor @Inject constructor(
    private val repository: IMainScreenRepository
) : ISettingsScreenInteractor {
}