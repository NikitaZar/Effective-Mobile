package ru.nikitazar.domain.model

import com.google.gson.annotations.SerializedName

data class HomeStoreSmartphone(

    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("is_new")
    val isNew: Boolean = false,
    @SerializedName("title")
    val title: String = "NoName",
    @SerializedName("subtitle")
    val subtitle: String = "",
    @SerializedName("picture")
    val picture: String = "",
    @SerializedName("is_buy")
    val isBuy: Boolean = false,
) : FeedItem
