package com.coderwise.interview.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderwise.interview.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListViewModel(
    itemsRepository: ItemsRepository
) : ViewModel() {

    val uiState = itemsRepository.items
        .map { items -> ListUiState(items) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ListUiState(
                emptyList()
            )
        )

    fun onIntent(intent: ListIntent) {
        viewModelScope.launch {
            when (intent) {
                is ListIntent.ItemClicked -> {
                    Log.d("ListViewModel", "Item clicked: ${intent.itemId}")
                }
            }
        }
    }
}
