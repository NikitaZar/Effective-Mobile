package ru.nikitazar.effectivemobile.viewModel

import android.app.Application
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.Category
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.domain.usecase.GetBestsellerListUseCase
import ru.nikitazar.domain.usecase.GetHomeStoreUseCase
import ru.nikitazar.domain.usecase.GetList
import ru.nikitazar.effectivemobile.R

class MainViewModel(
    private val getBestsellerListUseCase: GetBestsellerListUseCase,
    private val getHomeStoreUseCase: GetHomeStoreUseCase,
    getList: GetList,
    application: Application,
) : AndroidViewModel(application) {

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

    val dataCategory: LiveData<List<Category>>
        get() = _dataCategory


    private val list = listOf(
        Category(
            id = 0,
            icon = R.drawable.ic_iphone_24,
            text = application.getString(R.string.text_category_phones),
            isChecked = true
        ),
        Category(
            id = 1,
            icon = R.drawable.ic_computer_24,
            text = application.getString(R.string.text_category_computer)
        ),
        Category(
            id = 2,
            icon = R.drawable.ic_health_24,
            text = application.getString(R.string.text_category_health)
        ),
        Category(
            id = 3,
            icon = R.drawable.ic_book_24,
            text = application.getString(R.string.text_category_books)
        ),
    )

    private var _dataCategory = MutableLiveData(list)


    fun setCategory(id: Int) {
        list.forEach {
            it.isChecked = it.id == id

        }
        _dataCategory.postValue(list)
    }
}