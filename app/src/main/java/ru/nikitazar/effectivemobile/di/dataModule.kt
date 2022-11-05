package ru.nikitazar.effectivemobile.di

import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikitazar.data.repository.PhoneRepositoryImpl
import ru.nikitazar.domain.repository.PhoneRepository
import ru.nikitazar.effectivemobile.BuildConfig.BASE_URL

val dataModule = module {

    single<PhoneRepository> {
        PhoneRepositoryImpl(api = get())
    }

    single {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://run.mocky.io/v3/")
            .client(get())
            .build()
    }
}