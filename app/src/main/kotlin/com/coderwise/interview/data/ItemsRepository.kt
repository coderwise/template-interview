package com.coderwise.interview.data

import kotlinx.coroutines.flow.Flow

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String
)

interface ItemsRepository {
    fun getItems(): List<Item>
    fun getItem(id: Int): Item?

    val items: Flow<List<Item>>
}