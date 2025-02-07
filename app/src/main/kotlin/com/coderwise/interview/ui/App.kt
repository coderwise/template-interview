package com.coderwise.interview.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coderwise.interview.ui.details.DetailsRoute
import com.coderwise.interview.ui.details.DetailsScreen
import com.coderwise.interview.ui.list.ListRoute
import com.coderwise.interview.ui.list.ListScreen

@Composable
fun App() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = ListRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<ListRoute> {
                ListScreen(
                    onDetailsClick = { navController.navigate(DetailsRoute) }
                )
            }
            composable<DetailsRoute> {
                DetailsScreen()
            }
        }
    }
}