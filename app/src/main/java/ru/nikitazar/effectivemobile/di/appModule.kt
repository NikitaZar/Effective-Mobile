package ru.nikitazar.effectivemobile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel()
    }
}