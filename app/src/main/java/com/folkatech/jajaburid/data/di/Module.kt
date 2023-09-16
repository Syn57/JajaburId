package com.folkatech.jajaburid.data.di

import com.folkatech.jajaburid.BuildConfig
import com.folkatech.jajaburid.data.network.ApiService
import com.folkatech.jajaburid.data.repository.Repository
import com.folkatech.jajaburid.view.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//Dependency injection for retrofit
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

//Dependency injection for view model
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

//Dependency injection for repository
val repository = module {
    single { Repository(get()) }
}