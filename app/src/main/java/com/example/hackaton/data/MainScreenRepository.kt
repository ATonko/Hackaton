package com.example.hackaton.data

class MainScreenRepository(
    private val service: MainScreenService
) : IMainScreenRepository {

    override fun getSmt() {
        println("smth")
    }
}