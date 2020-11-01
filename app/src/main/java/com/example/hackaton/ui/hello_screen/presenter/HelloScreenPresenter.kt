package com.example.hackaton.ui.hello_screen.presenter

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.hello.IHelloScreenInteractor
import com.example.hackaton.ui.hello_screen.view.IHelloScreenView
import javax.inject.Inject

class HelloScreenPresenter @Inject constructor(
    private val interactor: IHelloScreenInteractor
) : Presenter<IHelloScreenView>(), IHelloScreenPresenter {

    override fun onContinueClick() {
        view?.goToPrimaryScreen()
    }
}