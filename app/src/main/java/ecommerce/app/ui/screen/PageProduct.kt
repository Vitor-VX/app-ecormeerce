package ecommerce.app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import com.google.gson.Gson
import ecommerce.app.R
import ecommerce.app.utils.ToastApp
import ecommerce.app.ui.components.button.AppButton
import ecommerce.app.ui.components.utils.Quadruple
import ecommerce.app.ui.theme.ECommerceAppTheme

object AppFonts {
    val fontDmSans = FontFamily(Font(resId = R.font.dm_sans))
    val fontPoppinsSemiBold = FontFamily(Font(resId = R.font.poppins_semibold))
    val fontPoppins = FontFamily(Font(resId = R.font.poppins))
}

@Composable
fun ProductPage(navBackStackEntry: NavBackStackEntry) {
    val info = retrieveProductInfo(navBackStackEntry = navBackStackEntry)
    if (info == null) {
        ToastApp.showToast("Product invalid")

        return
    }

    ProductContent(info = info)
}

@Composable
fun ProductContent(info: Quadruple) {
    val scrollState: ScrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1C))
            .padding(10.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(state = scrollState)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            ProductImage(imageRes = info.fourth)
            ProductDetails(info = info)
            LocalButtonsProduct()
        }
    }
}

@Composable
fun LocalButtonsProduct() {
    Spacer(modifier = Modifier.height(3.dp))
    AddToBagButton()
    Spacer(modifier = Modifier.height(15.dp))
    SaveProductButton()
}

@Composable
fun SaveProductButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF262626)
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_favorit_app),
            contentDescription = "Bag",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Save Product",
            fontFamily = AppFonts.fontDmSans,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
fun AddToBagButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF262626)
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_bag),
            contentDescription = "Bag",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Add to bag",
            fontFamily = AppFonts.fontDmSans,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ProductDetails(info: Quadruple) {
    Text(
        text = info.first,
        style = TextStyle(
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontFamily = AppFonts.fontDmSans
        )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = info.second,
        style = TextStyle(
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontFamily = AppFonts.fontPoppinsSemiBold
        )
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "Decrease",
                tint = Color.White
            )
        }

        Text(
            text = "01",
            color = Color.White,
            fontFamily = AppFonts.fontPoppinsSemiBold,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Increase",
                tint = Color.White
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            tint = Color(0xFFFFC107),
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = info.third,
            fontFamily = AppFonts.fontDmSans,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "(500 reviews)",
            fontFamily = AppFonts.fontDmSans,
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Facilisis tellus, est lacus arcu ut ac in fermentum.",
        color = Color(0xFFB0B0B0),
        fontFamily = AppFonts.fontPoppins,
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ProductImage(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Product Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        AppButton(
            onClick = { /* TODO */ },
            sizeBox = 40.dp,
            sizeButton = 25.dp,
            image = Icons.Default.ArrowBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(3.dp)
        )
    }
}

@Composable
fun retrieveProductInfo(navBackStackEntry: NavBackStackEntry): Quadruple? {
    val json = navBackStackEntry.arguments?.getString("info") ?: return null
    return Gson().fromJson(json, Quadruple::class.java)
}