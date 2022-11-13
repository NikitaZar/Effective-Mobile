package ru.nikitazar.effectivemobile.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikitazar.data.api.ApiHelper
import ru.nikitazar.data.api.ApiHelperImpl
import ru.nikitazar.data.api.ApiService
import ru.nikitazar.data.db.AppDb
import ru.nikitazar.data.db.SmartphoneDao
import ru.nikitazar.effectivemobile.BuildConfig
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

val appModule = module {
    viewModel {
        MainViewModel(
            getBestsellerListUseCase = get(),
            getHomeStoreUseCase = get(),
            getList = get(),
        )
    }
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideDb(get()) }
    single { provideSmartphoneDao(get()) }
}

private fun provideOkHttpClient() = OkHttpClient.Builder().build()

private fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .build()

private fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

//private fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

private fun provideDb(application: Application): AppDb =
    Room.databaseBuilder(application, AppDb::class.java, "app.db")
        .fallbackToDestructiveMigration()
        .build()

fun provideSmartphoneDao(db: AppDb): SmartphoneDao = db.smartphoneDao()