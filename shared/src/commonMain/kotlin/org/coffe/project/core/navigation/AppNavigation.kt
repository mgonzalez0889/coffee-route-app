package org.coffe.project.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(navigationConfig, Menu)

    NavDisplay(
        backStack = backStack, entryProvider = entryProvider {
            entry<Menu> {

            }

        }

    )

}