package org.coffe.project.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.coffe.project.features.menu.MenuScreen
import org.coffe.project.features.historia.HistoryScreen
import org.coffe.project.features.sitios.SitesScreen

@Composable
fun AppNavigation(
    backStack: TopLevelBackStack,
    modifier: Modifier = Modifier
) {

    NavDisplay(
        backStack = backStack.flattenedBackStack,
        onBack = { backStack.removeLastOrNull() },
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Menu> { MenuScreen() }

            entry<Historia> { HistoryScreen() }

            entry<Sitios> { SitesScreen() }
        }

    )

}