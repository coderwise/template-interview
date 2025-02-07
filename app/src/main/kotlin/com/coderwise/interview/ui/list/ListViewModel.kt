package com.coderwise.interview.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderwise.interview.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ListViewModel(
    itemsRepository: ItemsRepository
) : ViewModel() {

    val items = itemsRepository.items.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), emptyList()
    )

    /**
     * Called when an item is clicked.
     */
    fun onItemClicked(itemId: Int) {
        Log.d("ListViewModel", "onItemClicked: $itemId")
    }
}
