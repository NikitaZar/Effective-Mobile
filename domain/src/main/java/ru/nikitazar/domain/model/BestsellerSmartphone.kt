package ru.nikitazar.domain.model

import com.google.gson.annotations.SerializedName

data class BestsellerSmartphone(
    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("is_favorites")
    val isFavorites: Boolean = false,
    @SerializedName("title")
    val title: String = "NoName",
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Int = 0,
    @SerializedName("discount_price")
    val discountPrice: Int = 0,
    @SerializedName("picture")
    val picture: String = "",
): FeedItem
