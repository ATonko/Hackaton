package com.example.hackaton.ui.recomendations

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import javax.inject.Inject

class RecomendationsFragment : Fragment(R.layout.fragment_recomendations), IRecomendationsView {

    companion object {
        fun newInstance(): Fragment = Fragment()
    }

    @Inject
    lateinit var presenter: IRecomendationsPresenter

    init {
        ComponentManager.plusRecomendationsComponent().inject(this)
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
        ComponentManager.clearRecomendationsComponent()
        presenter.onDestroy()
    }
}
