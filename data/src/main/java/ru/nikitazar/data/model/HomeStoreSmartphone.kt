package ru.nikitazar.data.model

import ru.nikitazar.domain.model.HomeStoreSmartphone

data class HomeStoreSmartphone(
    val id: Int,
    val isNew: Boolean?,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
) {
    fun mapToDomain() =
        HomeStoreSmartphone(
            id = id,
            isNew = isNew,
            title = title,
            subtitle = subtitle,
            picture = picture,
            isBuy = isBuy
        )
}
