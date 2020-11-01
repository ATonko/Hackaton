package com.example.hackaton.di

import com.example.hackaton.business.hello.HelloScreenInteractor
import com.example.hackaton.business.hello.IHelloScreenInteractor
import com.example.hackaton.ui.hello_screen.HelloScreenFragment
import com.example.hackaton.ui.hello_screen.presenter.HelloScreenPresenter
import com.example.hackaton.ui.hello_screen.presenter.IHelloScreenPresenter
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [HelloScreenModule::class])
@HelloScreenScope
abstract class HelloScreenComponent {
    internal abstract fun inject(fragment: HelloScreenFragment)
}

@Module
internal interface HelloScreenModule {

    @Binds
    @HelloScreenScope
    fun bindInteractor(interactor: HelloScreenInteractor): IHelloScreenInteractor

    @Binds
    @HelloScreenScope
    fun providePresenter(presenter: HelloScreenPresenter): IHelloScreenPresenter

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HelloScreenScope
