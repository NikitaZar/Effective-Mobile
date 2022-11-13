package ru.nikitazar.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.nikitazar.domain.model.BestsellerSmartphone

@Entity
data class BestsellerSmartphoneEntity(
    @PrimaryKey
    val id: Int,
    val isFavorites: Boolean = false,
    val title: String,
    val priceWithoutDiscount: Int = 0,
    val discountPrice: Int = 0,
    val picture: String,
) {
    fun toDto() =
        BestsellerSmartphone(
            id = id,
            isFavorites = isFavorites,
            title = title,
            priceWithoutDiscount = priceWithoutDiscount,
            discountPrice = discountPrice,
            picture = picture
        )

    companion object {
        fun fromDto(dto: BestsellerSmartphone) = BestsellerSmartphoneEntity(
            id = dto.id,
            isFavorites = dto.isFavorites,
            title = dto.title,
            priceWithoutDiscount = dto.priceWithoutDiscount,
            discountPrice = dto.discountPrice,
            picture = dto.picture
        )
    }
}

fun List<BestsellerSmartphoneEntity>.toDto() = map { it.toDto() }
fun List<BestsellerSmartphone>.toEntity() = map { BestsellerSmartphoneEntity.fromDto(it) }
