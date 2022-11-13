package ru.nikitazar.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.nikitazar.domain.model.HomeStoreSmartphone

@Entity
data class HomeStoreSmartphoneEntity(
    @PrimaryKey
    val id: Int,
    val isNew: Boolean = false,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
) {
    fun toDto() =
        HomeStoreSmartphone(
            id = id,
            isNew = isNew,
            title = title,
            subtitle = subtitle,
            picture = picture,
            isBuy = isBuy
        )

    companion object {
        fun fromDto(dto: HomeStoreSmartphone) =
            HomeStoreSmartphoneEntity(
                id = dto.id,
                isNew = dto.isNew,
                title = dto.title,
                subtitle = dto.subtitle,
                picture = dto.picture,
                isBuy = dto.isBuy
            )
    }
}

fun List<HomeStoreSmartphoneEntity>.toDto() = map { it.toDto() }
fun List<HomeStoreSmartphone>.toEntity() = map { HomeStoreSmartphoneEntity.fromDto(it) }
