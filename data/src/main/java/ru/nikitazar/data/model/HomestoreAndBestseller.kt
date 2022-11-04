package ru.nikitazar.data.model

import com.google.gson.annotations.SerializedName

data class HomeStoreAndBestseller(
    @SerializedName("home_store")
    val homeStore: List<HomeStoreSmartphone>,
    @SerializedName("best_seller")
    val bestseller: List<BestsellerSmartphone>
)
