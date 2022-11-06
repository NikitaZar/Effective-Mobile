package ru.nikitazar.data.api

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getListOfLists() = apiService.getListOfLists()
}