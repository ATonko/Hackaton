package com.example.hackaton.business.main

import com.example.hackaton.data.IMainScreenRepository

class MainScreenInteractor(
    private val repository: IMainScreenRepository
) : IMainScreenInteractor {

    override fun getSmt() {
        repository.getSmt()
    }
}