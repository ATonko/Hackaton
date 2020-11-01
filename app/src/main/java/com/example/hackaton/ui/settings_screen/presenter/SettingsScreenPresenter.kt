package com.example.hackaton.ui.settings_screen.presenter

import com.example.hackaton.base.Presenter
import com.example.hackaton.business.settings.ISettingsScreenInteractor
import com.example.hackaton.ui.settings_screen.view.ISettingsScreenView
import javax.inject.Inject

class SettingsScreenPresenter @Inject constructor(
    private val interactor: ISettingsScreenInteractor
) : Presenter<ISettingsScreenView>(), ISettingsScreenPresenter {
}