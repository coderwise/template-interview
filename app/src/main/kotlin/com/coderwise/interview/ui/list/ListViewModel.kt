package com.coderwise.interview.ui.list

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
}
