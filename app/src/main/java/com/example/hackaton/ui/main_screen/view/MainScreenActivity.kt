package com.example.hackaton.ui.main_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import com.example.hackaton.ui.hello_screen.HelloScreenFragment
import com.example.hackaton.ui.main_screen.presenter.IMainScreenPresenter
import com.example.hackaton.utils.addFragment
import javax.inject.Inject

class MainScreenActivity : AppCompatActivity(), IMainScreenView {

    @Inject
    lateinit var presenter: IMainScreenPresenter

    init {
        ComponentManager.plusMainScreenComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.bindView(this)
        presenter.onViewReady()
    }

    override fun goToHelloScreen() {
        addFragment(HelloScreenFragment.newInstance())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
        presenter.onDestroy()
        ComponentManager.clearMainScreenComponent()
    }
}