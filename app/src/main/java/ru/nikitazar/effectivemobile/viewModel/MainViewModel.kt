package ru.nikitazar.effectivemobile.viewModel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.domain.usecase.GetBestsellerListUseCase
import ru.nikitazar.domain.usecase.GetHomeStoreUseCase
import ru.nikitazar.domain.usecase.GetList

class MainViewModel(
    private val getBestsellerListUseCase: GetBestsellerListUseCase,
    private val getHomeStoreUseCase: GetHomeStoreUseCase,
    getList: GetList,
) : ViewModel() {

    init {
        viewModelScope.launch {
            getList.execute()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val dataBestseller: LiveData<List<BestsellerSmartphone>>
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