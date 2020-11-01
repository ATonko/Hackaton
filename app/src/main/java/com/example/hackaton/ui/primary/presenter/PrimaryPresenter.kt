package com.example.hackaton.ui.primary.presenter

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.primary.IPrimaryInteractor
import com.example.hackaton.ui.primary.view.IPrimaryView
import javax.inject.Inject

class PrimaryPresenter @Inject constructor(
    private val interactor: IPrimaryInteractor
) : Presenter<IPrimaryView>(), IPrimaryPresenter {
}