package ru.nikitazar.effectivemobile.di

import org.koin.dsl.module
import ru.nikitazar.domain.usecase.GetBestsellerListUseCase
import ru.nikitazar.domain.usecase.GetHomeStoreUseCase

val domainModule = module {
    factory {
        GetHomeStoreUseCase(get())
    }

    factory {
        GetBestsellerListUseCase(get())
    }
}