package ru.nikitazar.domain.model

data class HomeStoreSmartphone(
    val id: Int,
    val isNew: Boolean?,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
)
