package ru.nikitazar.data.api

import retrofit2.http.GET
import ru.nikitazar.data.model.HomeStoreAndBestseller


interface MainApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getListOfLists(): HomeStoreAndBestseller
}