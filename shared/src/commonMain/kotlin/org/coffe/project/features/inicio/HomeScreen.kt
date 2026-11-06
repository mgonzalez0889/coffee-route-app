package org.coffe.project.features.inicio

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coffeprojectapp.shared.generated.resources.Res
import coffeprojectapp.shared.generated.resources.ic_coffee
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.delay
import org.coffe.project.models.HeaderDataCoffee
import org.coffe.project.ui.theme.CoffeeCreamMuted
import org.coffe.project.ui.theme.CoffeeDark
import org.coffe.project.ui.theme.CoffeeLight
import org.coffe.project.ui.theme.CoffeeMedium
import org.coffe.project.ui.theme.CoffeeMediumDark
import org.coffe.project.ui.theme.CoffeePrimary
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Duration.Companion.milliseconds


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
                        Text("Vive la Experiencia", color = CoffeeMediumDark, fontWeight = FontWeight.Bold)
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
                text = "Sobre el café",
                color = CoffeePrimary,
                fontWeight = FontWeight.Medium
            )
            CarouselCoffe()
        }
    }
}

@Composable
fun CarouselCoffe() {

    val headerDataCards = listOf(
        HeaderDataCoffee(titulo = "Es una fruta", descripcion = "El café es en realidad la semilla que está dentro del corazón de una baya roja llamada cereza de café.", imagenUrl = "https://plus.unsplash.com/premium_photo-1666976510011-28202995a11b?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D"),
        HeaderDataCoffee(titulo = "Las especies principales", descripcion =  "Para consumo humano se usan básicamente dos: la Arábica y la Robusta.", imagenUrl = "https://plus.unsplash.com/premium_photo-1724820188213-21bab4fb3f44?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D"),
        HeaderDataCoffee(titulo = "Asociaciones positivas", descripcion = "Estudios relacionan el café con menor riesgo de Parkinson, Alzheimer, diabetes tipo 2 y enfermedades del hígado.", imagenUrl=  "https://plus.unsplash.com/premium_photo-1675435644687-562e8042b9db?q=80&w=749&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D")
    )

    val pagerState = rememberPagerState(pageCount = { headerDataCards.size })

    LaunchedEffect(pagerState) {
        while (true) {
            delay(7000.milliseconds)

            val nextPage = (pagerState.currentPage + 1) % headerDataCards.size

            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) { page ->
            CardCarousel(
                headerData = headerDataCards[page],
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        IndicadorPaginas(
            totalPaginas = headerDataCards.size,
            paginaActual = pagerState.currentPage
        )

    }



}

@Composable
fun CardCarousel(headerData: HeaderDataCoffee, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = CoffeeLight
        )
    ) {
        Column {
            KamelImage({ asyncPainterResource(headerData.imagenUrl) },
                contentDescription = headerData.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                alpha = DefaultAlpha,
                colorFilter = null,
                onLoading = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = CoffeePrimary)
                    }
                },
                onFailure = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Icon(painterResource(Res.drawable.ic_coffee), contentDescription = "Error")
                    }
                },
                contentAlignment = Alignment.Center,
                animationSpec = null
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = headerData.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = CoffeeMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = headerData.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = CoffeeDark,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun IndicadorPaginas(
    totalPaginas: Int,
    paginaActual: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPaginas) { index ->
            val isSelected = index == paginaActual

            val ancho by animateDpAsState(
                targetValue = if (isSelected) 20.dp else 8.dp,
                label = "ancho"
            )

            val color by animateColorAsState(
                targetValue = if (isSelected) CoffeePrimary else CoffeeMediumDark.copy(alpha = 0.3f),
                label = "color"
            )

            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(ancho)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

