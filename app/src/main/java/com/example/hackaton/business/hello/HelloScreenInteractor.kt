package com.example.hackaton.business.hello

import com.example.hackaton.data.IMainScreenRepository
import javax.inject.Inject

class HelloScreenInteractor @Inject constructor(
    private val repository: IMainScreenRepository
) : IHelloScreenInteractor {
}