package com.example.hackaton.ui.recomendations

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.recomendations.IRecomendationsInteractor
import javax.inject.Inject

class RecomendationsPresenter @Inject constructor(
    private val interactor: IRecomendationsInteractor
) : Presenter<IRecomendationsView>(), IRecomendationsPresenter {
}