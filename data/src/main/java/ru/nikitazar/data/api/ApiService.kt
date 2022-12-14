package ru.nikitazar.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.nikitazar.data.model.HomeStoreAndBestseller

interface ApiService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getList(): Response<HomeStoreAndBestseller>
}

interface ApiHelper {
    suspend fun getList(): Response<HomeStoreAndBestseller>
}

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getList(): Response<HomeStoreAndBestseller> = apiService.getList()
}