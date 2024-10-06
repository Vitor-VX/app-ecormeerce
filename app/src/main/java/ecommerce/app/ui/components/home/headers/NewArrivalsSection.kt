package ecommerce.app.ui.components.home.headers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ecommerce.app.R
import ecommerce.app.ui.screen.AppImages
import ecommerce.app.ui.theme.Typography
import ecommerce.app.ui.utils.home.AnimateCarousel

@Composable
fun ImageCarousel() {
    val imgSize = AppImages.imagesCarouselApp.size
    val state = rememberPagerState { imgSize }
    AnimateCarousel(
        state = state,
        pageCount = imgSize
    )

    HorizontalPager(
        state = state
    ) { page ->
        Image(
            painter = painterResource(id = AppImages.imagesCarouselApp[page]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp),
        )
    }
}

@Composable
fun NewArrivalsSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF3A3C44), Color(0xFF1D1F24))
                    )
                )
                .fillMaxSize()
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Novidades",
                color = Color.White,
                fontSize = 20.sp,
                style = Typography.titleLarge
            )

            Text(
                text = "Confira os lançamentos diários",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(resId = R.font.dm_sans))
            )

            ImageCarousel()
        }
    }
}