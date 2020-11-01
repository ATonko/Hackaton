package com.example.hackaton.business.details

import com.example.hackaton.data.IMainScreenRepository
import javax.inject.Inject

class DetailsInteractor @Inject constructor(
    private val repository: IMainScreenRepository
) : IDetailsInteractor {
}