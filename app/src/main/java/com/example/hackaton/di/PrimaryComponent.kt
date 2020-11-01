package com.example.hackaton.di

import com.example.hackaton.business.primary.IPrimaryInteractor
import com.example.hackaton.business.primary.PrimaryInteractor
import com.example.hackaton.ui.primary.presenter.IPrimaryPresenter
import com.example.hackaton.ui.primary.presenter.PrimaryPresenter
import com.example.hackaton.ui.primary.view.PrimaryFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [PrimaryModule::class])
@PrimaryScope
abstract class PrimaryComponent {
    internal abstract fun inject(fragment: PrimaryFragment)
}

@Module
internal interface PrimaryModule {

    @Binds
    @PrimaryScope
    fun bindInteractor(interactor: PrimaryInteractor): IPrimaryInteractor

    @Binds
    @PrimaryScope
    fun bindPresenter(presenter: PrimaryPresenter): IPrimaryPresenter

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PrimaryScope
