package com.example.hackaton.ui.settings_screen.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import com.example.hackaton.ui.settings_screen.presenter.ISettingsScreenPresenter
import javax.inject.Inject

class SettingsScreenFragment : Fragment(R.layout.fragment_settings_screen), ISettingsScreenView {

    companion object {
        fun newInstance(): SettingsScreenFragment = SettingsScreenFragment()
    }

    @Inject
    lateinit var presenter: ISettingsScreenPresenter

    init {
        ComponentManager.plusSettingsScreenComponent().inject(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.bindView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun onDestroy() {
        super.onDestroy()
        ComponentManager.clearSettingsScreenComponent()
        presenter.onDestroy()
    }
}
