package com.coderwise.interview.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderwise.interview.data.Item
import com.coderwise.interview.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    onDetailsClick: (Int) -> Unit = {},
    viewModel: ListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    ListContent(
        uiState = uiState,
        onIntent = { intent ->
            when (intent) {
                is ListIntent.ItemClicked -> onDetailsClick(intent.itemId)
            }
            viewModel.onIntent(intent)
        }
    )
}

@Composable
private fun ListContent(
    uiState: ListUiState,
    onIntent: (ListIntent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(uiState.items.size) { index ->
            ListItem(
                item = uiState.items[index],
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onIntent(ListIntent.ItemClicked(uiState.items[index].id))
                    }
            )
        }
    }
}

@Composable
private fun ListItem(
    item: Item,
    modifier: Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    AppTheme {
        ListContent(
            uiState = ListUiState(
                List(10) {
                    Item(
                        id = it,
                        name = "Item $it",
                        description = "Description $it",
                        price = it.toDouble(),
                        imageUrl = ""
                    )
                },
            ),
            onIntent = {}
        )
    }
}
