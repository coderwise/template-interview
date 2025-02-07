package com.coderwise.interview.ui.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderwise.interview.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = koinViewModel()
) {
    DetailsContent()
}

@Composable
private fun DetailsContent() {
    Text(text = "Details", modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    AppTheme {
        DetailsContent()
    }
}