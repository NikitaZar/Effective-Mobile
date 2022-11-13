package ru.nikitazar.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.nikitazar.data.db.entity.BestsellerSmartphoneEntity
import ru.nikitazar.data.db.entity.HomeStoreSmartphoneEntity
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.model.HomeStoreSmartphone

@Dao
interface SmartphoneDao {

    @Query("SELECT * FROM BestsellerSmartphoneEntity ORDER BY id")
    fun getBestsellerSmartphones(): Flow<List<BestsellerSmartphoneEntity>>

    @Query("SELECT * FROM HomeStoreSmartphoneEntity ORDER BY id")
    fun getHomeStoreSmartphones(): Flow<List<HomeStoreSmartphoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBestsellerSmartphones(smartphones: List<BestsellerSmartphoneEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHomeStoreSmartphones(smartphones: List<HomeStoreSmartphoneEntity>)
}