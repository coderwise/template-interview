package com.coderwise.interview.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderwise.interview.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    onDetailsClick: () -> Unit = {},
    viewModel: ListViewModel = koinViewModel()
) {

    ListContent(
        onDetailsClick = onDetailsClick
    )
}

@Composable
fun ListContent(
    onDetailsClick: () -> Unit
) {
    Column {
        Text(text = "List", modifier = Modifier.padding(16.dp))
        Button(
            onClick = { onDetailsClick() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Go To Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    AppTheme {
        ListContent(
            onDetailsClick = {}
        )
    }
}
