package org.coffe.project.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.coffe.project.core.navigation.AppNavigation
import org.coffe.project.core.navigation.Historia
import org.coffe.project.core.navigation.Menu
import org.coffe.project.core.navigation.Sitios
import org.coffe.project.core.navigation.rememberTopLevelBackStack
import org.coffe.project.ui.theme.CoffeeAccent
import org.coffe.project.ui.theme.CoffeeCreamMuted
import org.coffe.project.ui.theme.CoffeeDark
import org.coffe.project.ui.theme.CoffeeLight
import org.coffe.project.ui.theme.CoffeeMedium
import org.coffe.project.ui.theme.CoffeeMediumDark
import org.coffe.project.ui.theme.CoffeePrimary
import org.coffe.project.ui.theme.PrimaryText

@Composable
fun RootNavigation() {
    val backStack = rememberTopLevelBackStack(Menu)

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
                containerColor = CoffeeAccent,
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                NavigationBarItem(
                    selected = backStack.topLevelKey == Menu,
                    onClick = { backStack.addTopLevel(Menu) },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Icon(Icons.Default.Home, contentDescription = "Inicio")
                            Text("Inicio")
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = CoffeeDark,
                        selectedTextColor = PrimaryText,
                        indicatorColor = CoffeePrimary.copy(alpha = 0.2f),
                        unselectedIconColor = CoffeeMediumDark,
                        unselectedTextColor = CoffeeMediumDark
                    )
                )
                NavigationBarItem(
                    selected = backStack.topLevelKey == Historia,
                    onClick = { backStack.addTopLevel(Historia) },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Historia")
                            Text("Historia")
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = CoffeeDark,
                        selectedTextColor = CoffeeDark,
                        indicatorColor = CoffeePrimary.copy(alpha = 0.2f),
                        unselectedIconColor = CoffeeMediumDark,
                        unselectedTextColor = CoffeeMediumDark
                    )
                )
                NavigationBarItem(
                    selected = backStack.topLevelKey == Sitios,
                    onClick = { backStack.addTopLevel(Sitios) },
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Icon(Icons.Default.Coffee, contentDescription = "Sitios")
                            Text("Sitios")
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = CoffeeDark,
                        selectedTextColor = CoffeeDark,
                        indicatorColor = CoffeePrimary.copy(alpha = 0.2f),
                        unselectedIconColor = CoffeeMediumDark,
                        unselectedTextColor = CoffeeMediumDark
                    )
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