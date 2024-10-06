package ecommerce.app.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    onClick: () -> Unit,
    image: ImageVector,
    sizeBox: Dp = 20.dp,
    sizeButton: Dp = 20.dp,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .size(sizeBox)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF3A3C44),
                        Color(0xFF1D1F24)
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .padding(5.dp)
    ) {
        Image(
            imageVector = image, //if (!enter) Icons.Default.ArrowForward else Icons.Default.ArrowBack,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color.White),
            modifier = Modifier
                .align(Alignment.Center)
                .size(sizeButton)
                .padding(horizontal = 4.dp)
        )
    }
}