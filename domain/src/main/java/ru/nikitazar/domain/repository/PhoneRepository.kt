package ru.nikitazar.domain.repository

import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone

interface PhoneRepository {
    suspend fun getHomeStore(): List<HomeStoreSmartphone>
    suspend fun getBestSeller(): List<BestsellerSmartphone>
}