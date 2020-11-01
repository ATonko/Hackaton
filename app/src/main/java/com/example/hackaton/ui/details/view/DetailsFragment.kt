package com.example.hackaton.ui.details.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hackaton.R
import com.example.hackaton.di.ComponentManager
import com.example.hackaton.ui.details.presenter.IDetailsPresenter
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details), IDetailsView {

    companion object {
        fun newInstance(): DetailsFragment = DetailsFragment()
    }

    @Inject
    lateinit var presenter: IDetailsPresenter

    init {
        ComponentManager.plusDetailsComponent().inject(this)
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
        ComponentManager.clearDetailsComponent()
        presenter.onDestroy()
    }
}
