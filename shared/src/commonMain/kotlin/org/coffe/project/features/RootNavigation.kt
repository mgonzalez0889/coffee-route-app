package org.coffe.project.features

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.coffe.project.core.navigation.AppNavigation
import org.coffe.project.core.navigation.Historia
import org.coffe.project.core.navigation.Menu
import org.coffe.project.core.navigation.Sitios
import org.coffe.project.core.navigation.rememberTopLevelBackStack

@Composable
fun RootNavigation() {
    val backStack = rememberTopLevelBackStack(Menu)

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = backStack.topLevelKey == Menu,
                    onClick = { backStack.addTopLevel(Menu) },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") }
                )
                NavigationBarItem(
                    selected = backStack.topLevelKey == Historia,
                    onClick = { backStack.addTopLevel(Historia) },
                    icon = { Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Historia") },
                    label = { Text("Historia") }
                )
                NavigationBarItem(
                    selected = backStack.topLevelKey == Sitios,
                    onClick = { backStack.addTopLevel(Sitios) },
                    icon = { Icon(Icons.Default.Coffee, contentDescription = "Sitios") },
                    label = { Text("Stios") }
                )
            }
        }
    ) { innerPadding ->
        AppNavigation(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding)
        )
    }
}