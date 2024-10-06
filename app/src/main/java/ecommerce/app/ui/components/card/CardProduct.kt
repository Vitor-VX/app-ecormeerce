package ecommerce.app.ui.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ecommerce.app.R
import ecommerce.app.ui.components.button.AppButton

@Composable
fun CardProduct(
    name: String,
    value: String,
    img: Int,
    notice: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(0.45f)
            .aspectRatio(0.72f)
            .clip(shape = RoundedCornerShape(13.dp))
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF363941),
                        Color(0xFF3E424B)
                    )
                )
            )
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Image(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = Color(0xFFE0C302)),
                modifier = Modifier.size(13.dp)
            )

            Text(
                text = notice,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = name,
            color = Color.White,
            fontSize = 13.sp,
            fontFamily = FontFamily(Font(resId = R.font.dm_sans)),
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = value,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            AppButton(
                onClick = onClick,
                image = Icons.Default.ArrowForward,
                sizeButton = 25.dp,
                sizeBox = 30.dp,
                modifier = Modifier
            )
        }
    }
}