package ru.nikitazar.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import ru.nikitazar.data.api.ApiHelper
import ru.nikitazar.data.db.SmartphoneDao
import ru.nikitazar.data.db.entity.*
import ru.nikitazar.data.error.*
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

    override suspend fun getList() {
        try {
            val response = api.getList()
            val body = response.body()
                ?: throw ApiError(response.code(), response.message())
            dao.insertBestsellerSmartphones(body.bestseller.toEntity())
            dao.insertHomeStoreSmartphones(body.homeStore.toEntity())
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