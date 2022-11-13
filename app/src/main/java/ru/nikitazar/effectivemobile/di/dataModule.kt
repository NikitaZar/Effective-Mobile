package ru.nikitazar.effectivemobile.di

import org.koin.dsl.module
import ru.nikitazar.data.api.ApiHelper
import ru.nikitazar.data.api.ApiHelperImpl
import ru.nikitazar.data.repository.PhoneRepositoryImpl
import ru.nikitazar.domain.repository.PhoneRepository

val dataModule = module {

    single<PhoneRepository> {
        PhoneRepositoryImpl(api = get(), dao = get())
    }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}