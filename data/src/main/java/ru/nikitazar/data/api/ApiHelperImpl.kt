package ru.nikitazar.data.api

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getList() = apiService.getListOfLists()
}