package com.example.hackaton.business.recomendations

import com.example.hackaton.data.IMainScreenRepository
import javax.inject.Inject

class RecomendationsInteractor @Inject constructor(
    private val repository: IMainScreenRepository
) : IRecomendationsInteractor {
}