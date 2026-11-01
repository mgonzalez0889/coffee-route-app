package org.coffe.project.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CoffeeLightColorScheme = lightColorScheme(
    primary = CoffeePrimary,
    onPrimary = Color.White,
    secondary = CoffeeAccent,
    onSecondary = Color.White,
    background = Background,
    onBackground = PrimaryText,
    surface = Surface,
    onSurface = PrimaryText,
    onSurfaceVariant = SecondaryText,
    outline = Divider
)

@Composable
fun RouteCoffeeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = CoffeeLightColorScheme,
        content = content
    )
}