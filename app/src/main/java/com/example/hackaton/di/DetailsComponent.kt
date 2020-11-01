package com.example.hackaton.di

import com.example.hackaton.business.details.DetailsInteractor
import com.example.hackaton.business.details.IDetailsInteractor
import com.example.hackaton.ui.details.presenter.DetailsPresenter
import com.example.hackaton.ui.details.presenter.IDetailsPresenter
import com.example.hackaton.ui.details.view.DetailsFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [DetailsModule::class])
@DetailsScope
abstract class DetailsComponent {
    internal abstract fun inject(fragment: DetailsFragment)
}

@Module
internal interface DetailsModule {

    @Binds
    @DetailsScope
    fun bindInteractor(interactor: DetailsInteractor): IDetailsInteractor

    @Binds
    @DetailsScope
    fun bindPresenter(presenter: DetailsPresenter): IDetailsPresenter

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DetailsScope