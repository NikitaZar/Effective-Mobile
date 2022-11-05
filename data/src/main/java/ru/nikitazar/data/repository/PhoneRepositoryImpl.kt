package ru.nikitazar.data.repository

import ru.nikitazar.data.api.MainApi
import ru.nikitazar.domain.repository.PhoneRepository

class PhoneRepositoryImpl(private val api: MainApi) : PhoneRepository {

    override suspend fun getHomeStore() = api.getListOfLists().homeStore.map { it.mapToDomain() }

    override suspend fun getBestSeller() = api.getListOfLists().bestseller.map { it.mapToDomain() }
}