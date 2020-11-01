package com.example.hackaton.base

interface IPresenter<in T : IView> {
    fun bindView(view: T)
    fun unbindView()
    fun onViewReady()
    fun onDestroy()
}