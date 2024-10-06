package ecommerce.app.ui.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ecommerce.app.R
import ecommerce.app.ui.components.utils.AppColors
import ecommerce.app.ui.theme.ECommerceAppTheme
import ecommerce.app.ui.theme.Typography


@Composable
fun CartIconWithBadge(itemCount: String) {
    Box(
        modifier = Modifier.size(48.dp)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.img_car_sale),
                contentDescription = "Cart Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.Center)
            )
        }

        if (itemCount.toInt() > 0) {
            Box(
                modifier = Modifier
                    .background(color = Color(0x54999595), shape = CircleShape)
                    .size(15.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = itemCount,
                    color = Color.White,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 8.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(0.dp)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PixelsCo.",
                    style = Typography.titleLarge,
                    color = Color.White
                )
            }
        },
        actions = {
            CartIconWithBadge(itemCount = "2")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppColors.BackgroundAppColor
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GetViewTopBarApp() {
    ECommerceAppTheme {
        TopBarApp()
    }
}