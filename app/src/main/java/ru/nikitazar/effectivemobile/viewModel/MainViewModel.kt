package ru.nikitazar.effectivemobile.viewModel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.domain.usecase.GetBestsellerListUseCase
import ru.nikitazar.domain.usecase.GetHomeStoreUseCase

class MainViewModel(
    private val getBestsellerListUseCase: GetBestsellerListUseCase,
    private val getHomeStoreUseCase: GetHomeStoreUseCase
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val dataBestSeller: LiveData<List<BestsellerSmartphone>>
        get() = _dataBestSeller
            .asFlow()
            .flatMapLatest { getBestsellerListUseCase.execute() }
            .asLiveData(Dispatchers.Default)
    private val _dataBestSeller = MutableLiveData<List<BestsellerSmartphone>>(emptyList())

    @OptIn(ExperimentalCoroutinesApi::class)
    val dataHomeStore: LiveData<List<HomeStoreSmartphone>>
        get() = _dataHomeStore
            .asFlow()
            .flatMapLatest { getHomeStoreUseCase.execute() }
            .asLiveData(Dispatchers.Default)
    private val _dataHomeStore = MutableLiveData<List<HomeStoreSmartphone>>(emptyList())
}