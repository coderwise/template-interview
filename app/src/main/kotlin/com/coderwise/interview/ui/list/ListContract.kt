package com.coderwise.interview.ui.list

import com.coderwise.interview.data.Item
import kotlinx.serialization.Serializable

@Serializable
data object ListRoute

data class ListUiState(
    val items: List<Item>
)

sealed interface ListIntent {
    data class ItemClicked(val itemId: Int) : ListIntent
}