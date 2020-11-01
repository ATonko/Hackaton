package com.example.hackaton.base

import io.reactivex.disposables.CompositeDisposable

abstract class Presenter<T : IView> : IPresenter<T> {
    protected var view: T? = null
    protected var compositeDisposable = CompositeDisposable()

    override fun bindView(view: T) {
        this.view = view
    }

    override fun onViewReady() {

    }

    override fun unbindView() {
        view = null
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}