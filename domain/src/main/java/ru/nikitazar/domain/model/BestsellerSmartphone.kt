package ru.nikitazar.domain.model

data class BestsellerSmartphone(
    val id: Int,
    val isFavorites: Boolean?,
    val title: String,
    val priceWithoutDiscount: Int?,
    val discountPrice: Int?,
    val picture: String,
)
