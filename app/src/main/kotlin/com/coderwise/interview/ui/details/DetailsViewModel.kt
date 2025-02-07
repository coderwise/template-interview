package com.coderwise.interview.ui.details

import androidx.lifecycle.ViewModel
import com.coderwise.interview.data.ItemsRepository
import kotlinx.coroutines.flow.MutableStateFlow

class DetailsViewModel(
    itemId: Int,
    itemsRepository: ItemsRepository
): ViewModel() {

    val item = MutableStateFlow(itemsRepository.getItem(itemId))
}
