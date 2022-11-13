package ru.nikitazar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nikitazar.data.db.entity.BestsellerSmartphoneEntity
import ru.nikitazar.data.db.entity.HomeStoreSmartphoneEntity

@Database(
    entities = [
        BestsellerSmartphoneEntity::class,
        HomeStoreSmartphoneEntity::class
    ],
    version = 2
)
abstract class AppDb : RoomDatabase() {
    abstract fun smartphoneDao(): SmartphoneDao
}