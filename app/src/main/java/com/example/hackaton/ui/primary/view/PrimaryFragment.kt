package com.example.hackaton.ui.primary.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import com.example.hackaton.ui.primary.presenter.IPrimaryPresenter
import javax.inject.Inject

class PrimaryFragment : Fragment(R.layout.fragment_primary), IPrimaryView {

    companion object {
        fun newInstance(): PrimaryFragment = PrimaryFragment()
    }

    @Inject
    lateinit var presenter: IPrimaryPresenter

    init {
        ComponentManager.plusPrimaryComponent().inject(this)
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
        ComponentManager.clearPrimaryComponent()
        presenter.onDestroy()
    }
}
