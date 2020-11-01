package com.example.hackaton.ui.details.presenter

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.details.IDetailsInteractor
import com.example.hackaton.ui.details.view.IDetailsView
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val interactor: IDetailsInteractor
) : Presenter<IDetailsView>(), IDetailsPresenter {
}