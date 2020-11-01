package com.example.hackaton.ui.hello_screen.presenter

import com.example.hackaton.base.IPresenter
import com.example.hackaton.ui.hello_screen.view.IHelloScreenView

interface IHelloScreenPresenter : IPresenter<IHelloScreenView> {

    fun onContinueClick()

}
