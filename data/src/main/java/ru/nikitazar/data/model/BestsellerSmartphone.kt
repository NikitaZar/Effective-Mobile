package ru.nikitazar.data.model

import ru.nikitazar.domain.model.BestsellerSmartphone

data class BestsellerSmartphone(
    val id: Int,
    val isFavorites: Boolean?,
    val title: String,
    val priceWithoutDiscount: Int?,
    val discountPrice: Int?,
    val picture: String,
) {
    fun mapToDomain() =
        BestsellerSmartphone(
            id = id,
            isFavorites = isFavorites,
            title = title,
            priceWithoutDiscount = priceWithoutDiscount,
            discountPrice = discountPrice,
            picture = picture
        )
}
