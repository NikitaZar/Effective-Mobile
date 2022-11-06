package ru.nikitazar.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone

interface PhoneRepository {
   val dataHomeStore: Flow<List<HomeStoreSmartphone>>
   val dataBestSeller: Flow<List<BestsellerSmartphone>>

    suspend fun getList()
}