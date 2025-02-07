package com.coderwise.interview.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import org.koin.core.parameter.parametersOf

@Composable
fun DetailsScreen(
    args: DetailsRoute,
    viewModel: DetailsViewModel = koinViewModel { parametersOf(args.itemId) }
) {
    val item by viewModel.item.collectAsState()

    item?.let {
        DetailsContent(item = it)
    } ?: DetailsError()
}

@Composable
private fun DetailsError() {
    Text(text = "Error", modifier = Modifier.padding(16.dp))
}

@Composable
private fun DetailsContent(
    item: Item
) {
    Column {
        Text(text = item.name, modifier = Modifier.padding(16.dp))
        Text(text = item.description, modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    AppTheme {
        DetailsContent(
            item = Item(
                id = 0,
                name = "Item 0",
                description = "Description 0",
                price = 0.0,
                imageUrl = ""
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsErrorPreview() {
    AppTheme {
        DetailsError()
    }
}