package ru.nikitazar.domain.model

data class Category(
    var id: Int = 0,
    val icon: Int,
    val text: String,
    var isChecked: Boolean = false
)
