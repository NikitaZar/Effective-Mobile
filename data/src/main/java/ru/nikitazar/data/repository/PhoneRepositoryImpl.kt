package ru.nikitazar.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import ru.nikitazar.data.api.ApiHelper
import ru.nikitazar.data.db.SmartphoneDao
import ru.nikitazar.data.db.entity.*
import ru.nikitazar.data.error.*
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.domain.repository.PhoneRepository
import java.io.IOException
import java.sql.SQLException

class PhoneRepositoryImpl(
    private val api: ApiHelper,
    private val dao: SmartphoneDao
) : PhoneRepository {

    override val dataBestSeller =
        dao.getBestsellerSmartphones()
            .map(List<BestsellerSmartphoneEntity>::toDto)
            .flowOn(Dispatchers.Default)

    override val dataHomeStore =
        dao.getHomeStoreSmartphones()
            .map(List<HomeStoreSmartphoneEntity>::toDto)
            .flowOn(Dispatchers.Default)

    override suspend fun getHomeStore() {
        try {
            val response = api.getListOfLists()
            val body = response.body()?.homeStore
                ?: throw ApiError(response.code(), response.message())
            dao.insertHomeStoreSmartphones(body.toEntity())
        } catch (e: ApiError) {
            throw e
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: SQLException) {
            throw DbError
        } catch (e: Exception) {
            throw UnknownError
        }
    }

    override suspend fun getBestSeller() {
        try {
            val response = api.getListOfLists()
            val body = response.body()?.bestseller
                ?: throw ApiError(response.code(), response.message())
            dao.insertBestsellerSmartphones(body.toEntity())
        } catch (e: ApiError) {
            throw e
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: SQLException) {
            throw DbError
        } catch (e: Exception) {
            throw UnknownError
        }
    }
}