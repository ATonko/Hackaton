package com.example.hackaton.ui.main_screen.presenter

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.main.IMainScreenInteractor
import com.example.hackaton.ui.main_screen.view.IMainScreenView

class MainScreenPresenter(
    private val interactor: IMainScreenInteractor
) : Presenter<IMainScreenView>(), IMainScreenPresenter {

    override fun onViewReady() {
        view?.goToHelloScreen()
    }

}