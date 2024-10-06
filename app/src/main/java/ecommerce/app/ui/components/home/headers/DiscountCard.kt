package ecommerce.app.ui.components.home.headers

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ecommerce.app.R
import ecommerce.app.ui.components.button.CustomButton


@Composable
fun DiscountCard(event: @Composable (Boolean) -> Unit = {}) {
    var startAnimation by remember { mutableStateOf(false) }
    var showEvent by remember { mutableStateOf(false) }

    val animatedValue by animateIntAsState(
        targetValue = if (startAnimation) 50 else 0,
        animationSpec = tween(durationMillis = 1500),
        finishedListener = {
            showEvent = true
        },
        label = ""
    )

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF3A3C44), Color(0xFF1D1F24))
                    )
                )
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Que tal ganhar até ")

                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFFC90909),
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("$animatedValue%")
                        }

                        append(" de desconto na primeira compra?")
                    },
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(resId = R.font.poppins)),
                    textAlign = TextAlign.Center
                )

                AnimatedVisibility(visible = animatedValue == 50) {
                    CustomButton(onClick = {})
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_tenis_01),
                contentDescription = null,
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .align(Alignment.CenterVertically)
            )
        }
    }

    AnimatedVisibility(visible = showEvent) {
        event(true)
    }
}