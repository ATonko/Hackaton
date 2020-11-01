package com.example.hackaton.business.primary

import com.example.hackaton.data.IMainScreenRepository
import javax.inject.Inject

class PrimaryInteractor @Inject constructor(
    private val repository: IMainScreenRepository
) : IPrimaryInteractor {
}