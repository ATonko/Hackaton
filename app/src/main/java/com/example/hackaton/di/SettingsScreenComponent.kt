package com.example.hackaton.di

import com.example.hackaton.business.settings.ISettingsScreenInteractor
import com.example.hackaton.business.settings.SettingsScreenInteractor
import com.example.hackaton.ui.settings_screen.presenter.ISettingsScreenPresenter
import com.example.hackaton.ui.settings_screen.presenter.SettingsScreenPresenter
import com.example.hackaton.ui.settings_screen.view.SettingsScreenFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [SettingsScreenModule::class])
@SettingsScreenScope
abstract class SettingsScreenComponent {
    internal abstract fun inject(fragment: SettingsScreenFragment)
}

@Module
internal interface SettingsScreenModule {

    @Binds
    @SettingsScreenScope
    fun bindInteractor(interactor: SettingsScreenInteractor): ISettingsScreenInteractor

    @Binds
    @SettingsScreenScope
    fun providePresenter(presenter: SettingsScreenPresenter): ISettingsScreenPresenter

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SettingsScreenScope
