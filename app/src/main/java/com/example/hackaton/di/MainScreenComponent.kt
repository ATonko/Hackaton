package com.example.hackaton.di

import com.example.hackaton.business.main.IMainScreenInteractor
import com.example.hackaton.business.main.MainScreenInteractor
import com.example.hackaton.data.IMainScreenRepository
import com.example.hackaton.data.MainScreenRepository
import com.example.hackaton.data.MainScreenService
import com.example.hackaton.ui.main_screen.presenter.IMainScreenPresenter
import com.example.hackaton.ui.main_screen.presenter.MainScreenPresenter
import com.example.hackaton.ui.main_screen.view.MainScreenActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Component(modules = [MainScreenModule::class, NetworkModule::class])
@MainScreenScope
abstract class MainScreenComponent {
    internal abstract fun inject(activity: MainScreenActivity)

    internal abstract fun plusHelloScreenComponent(): HelloScreenComponent
    abstract fun plusSettingsScreenComponent(): SettingsScreenComponent
    abstract fun plusPrimaryComponent(): PrimaryComponent
    abstract fun plusDetailsComponent(): DetailsComponent
    abstract fun plusRecomendationsComponent(): RecomendationsComponent
}

@Module
internal class MainScreenModule {
    @Provides
    @MainScreenScope
    fun provideRepository(service: MainScreenService): IMainScreenRepository =
        MainScreenRepository(service)

    @Provides
    @MainScreenScope
    fun provideInteractor(repository: IMainScreenRepository): IMainScreenInteractor =
        MainScreenInteractor(repository)

    @Provides
    @MainScreenScope
    fun providePresenter(interactor: IMainScreenInteractor): IMainScreenPresenter =
        MainScreenPresenter(interactor)

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScreenScope