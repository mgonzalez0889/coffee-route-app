package org.coffe.project.features.inicio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coffeprojectapp.shared.generated.resources.Res
import coffeprojectapp.shared.generated.resources.ic_coffee
import org.coffe.project.ui.theme.CoffeeCreamMuted
import org.coffe.project.ui.theme.CoffeeDark
import org.coffe.project.ui.theme.CoffeeLight
import org.coffe.project.ui.theme.CoffeeMediumDark
import org.coffe.project.ui.theme.CoffeePrimary
import org.jetbrains.compose.resources.painterResource


@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = CoffeeCreamMuted,
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Icon(
                            painter = painterResource(Res.drawable.ic_coffee),
                            contentDescription = "Coffee",
                            tint = CoffeeMediumDark,
                            modifier = Modifier.size(32.dp)
                        )
                        Text("Vive la Experiencia", color = CoffeeMediumDark)
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CoffeeCreamMuted,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
    ) {paddingValues  ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "El maravilloso mundo del café",
                color = CoffeePrimary,
                fontWeight = FontWeight.Medium
            )
        }
    }

}