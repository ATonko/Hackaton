package com.example.hackaton.ui.hello_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import com.example.hackaton.ui.hello_screen.presenter.IHelloScreenPresenter
import com.example.hackaton.ui.hello_screen.view.IHelloScreenView
import com.example.hackaton.ui.primary.view.PrimaryFragment
import com.example.hackaton.utils.replaceFragmentWithoutBack
import kotlinx.android.synthetic.main.fragment_hello_screen.*
import javax.inject.Inject

class HelloScreenFragment : Fragment(R.layout.fragment_hello_screen), IHelloScreenView {

    companion object {
        fun newInstance(): HelloScreenFragment = HelloScreenFragment()
    }

    @Inject
    lateinit var presenter: IHelloScreenPresenter

    init {
        ComponentManager.plusHelloScreenComponent().inject(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.bindView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListners()

        presenter.onViewReady()
    }

    override fun goToPrimaryScreen() {
        activity?.replaceFragmentWithoutBack(PrimaryFragment.newInstance())
    }

    private fun setupListners() {
        btnContinue.setOnClickListener { presenter.onContinueClick() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun onDestroy() {
        super.onDestroy()
        ComponentManager.clearHelloScreenComponent()
        presenter.onDestroy()
    }
}