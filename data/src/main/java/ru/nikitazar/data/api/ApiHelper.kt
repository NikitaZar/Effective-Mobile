package ru.nikitazar.data.api

import retrofit2.Response
import ru.nikitazar.data.model.HomeStoreAndBestseller

interface ApiHelper {
    suspend fun getList(): Response<HomeStoreAndBestseller>
}