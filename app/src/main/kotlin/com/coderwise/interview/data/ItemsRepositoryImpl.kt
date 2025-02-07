package com.coderwise.interview.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ItemsRepositoryImpl : ItemsRepository {

    override fun getItems(): List<Item> = demoItems

    override fun getItem(id: Int): Item? = demoItems.find { it.id == id }

    override val items: Flow<List<Item>> = flowOf(demoItems)

    companion object {
        private val demoItems = List(50) { index ->
            Item(
                id = index,
                name = "Item $index",
                description = "Description $index",
                price = index.toDouble(),
                imageUrl = "https://picsum.photos/200/300?random=$index"
            )
        }
    }
}