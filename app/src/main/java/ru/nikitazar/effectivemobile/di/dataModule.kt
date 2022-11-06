package ru.nikitazar.effectivemobile.di

import org.koin.dsl.module
import ru.nikitazar.data.repository.PhoneRepositoryImpl
import ru.nikitazar.domain.repository.PhoneRepository

val dataModule = module {

    single<PhoneRepository> {
        PhoneRepositoryImpl(api = get(), dao = get())
    }

}