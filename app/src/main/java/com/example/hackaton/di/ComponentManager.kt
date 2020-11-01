package com.example.hackaton.di

import com.example.hackaton.data.MainScreenService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ComponentManager {
    private var primaryComponent: PrimaryComponent? = null
    private var recomendationsComponent: RecomendationsComponent? = null
    private var detailsComponent: DetailsComponent? = null
    private var mainScreenComponent: MainScreenComponent? = null
    private var helloScreenComponent: HelloScreenComponent? = null
    private var settingsScreenComponent: SettingsScreenComponent? = null

    fun plusMainScreenComponent(): MainScreenComponent =
        mainScreenComponent ?: DaggerMainScreenComponent
            .builder()
            .build()
            .also { mainScreenComponent = it }

    fun plusHelloScreenComponent(): HelloScreenComponent =
        helloScreenComponent ?: plusMainScreenComponent()
            .plusHelloScreenComponent()
            .also { helloScreenComponent = it }

    fun plusSettingsScreenComponent(): SettingsScreenComponent =
        settingsScreenComponent ?: plusMainScreenComponent()
            .plusSettingsScreenComponent()
            .also { settingsScreenComponent = it }

    fun plusDetailsComponent(): DetailsComponent =
        detailsComponent ?: plusMainScreenComponent()
            .plusDetailsComponent()
            .also { detailsComponent = it }

    fun plusPrimaryComponent(): PrimaryComponent =
        primaryComponent ?: plusMainScreenComponent()
            .plusPrimaryComponent()
            .also { primaryComponent = it }

    fun plusRecomendationsComponent(): RecomendationsComponent =
        recomendationsComponent ?: plusMainScreenComponent()
            .plusRecomendationsComponent()
            .also { recomendationsComponent = it }

    fun clearMainScreenComponent() {
        mainScreenComponent = null
    }

    fun clearHelloScreenComponent() {
        helloScreenComponent = null
    }

    fun clearSettingsScreenComponent() {
        settingsScreenComponent = null
    }

    fun clearPrimaryComponent() {
        primaryComponent = null
    }

    fun clearRecomendationsComponent() {
        recomendationsComponent = null
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }

}

@Module
internal class NetworkModule {

    private companion object {
        const val BASE_URL = "https://hackton-5ce00.firebaseio.com"
    }

    @Provides
    @MainScreenScope
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @MainScreenScope
    fun provideConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    @MainScreenScope
    fun provideOkHttpClientWithTimeout(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @MainScreenScope
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(okHttpClient)
            .build()

    @Provides
    @MainScreenScope
    fun provideService(retrofit: Retrofit): MainScreenService =
        retrofit.create(MainScreenService::class.java)
}