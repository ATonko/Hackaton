package com.example.hackaton.di

import com.example.hackaton.business.recomendations.IRecomendationsInteractor
import com.example.hackaton.business.recomendations.RecomendationsInteractor
import com.example.hackaton.ui.recomendations.IRecomendationsPresenter
import com.example.hackaton.ui.recomendations.RecomendationsFragment
import com.example.hackaton.ui.recomendations.RecomendationsPresenter
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [RecomendationsModule::class])
@RecomendationsScope
abstract class RecomendationsComponent {
    internal abstract fun inject(fragment: RecomendationsFragment)
}

@Module
internal interface RecomendationsModule {

    @Binds
    @RecomendationsScope
    fun bindInteractor(interactor: RecomendationsInteractor): IRecomendationsInteractor

    @Binds
    @RecomendationsScope
    fun bindPresenter(presenter: RecomendationsPresenter): IRecomendationsPresenter

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RecomendationsScope