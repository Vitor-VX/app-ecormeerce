package ecommerce.app.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.google.gson.Gson
import ecommerce.app.R
import ecommerce.app.ui.components.card.CardProduct
import ecommerce.app.ui.components.home.headers.DiscountCard
import ecommerce.app.ui.components.home.headers.FeaturedWeek
import ecommerce.app.ui.components.home.headers.NewArrivalsSection
import ecommerce.app.ui.components.topbar.TopBarApp
import ecommerce.app.ui.components.utils.AppColors
import ecommerce.app.ui.components.utils.Quadruple
import ecommerce.app.ui.theme.ECommerceAppTheme

var navControllerGlobal: NavController? = null

object AppImages {
    val imagesCarouselApp = listOf(
        R.drawable.ic_tenis_10,
        R.drawable.ic_tenis_11,
        R.drawable.ic_tenis_12
    )

    val imagesBottomNavigation = listOf(
        R.drawable.ic_home_app,
        R.drawable.ic_favorit_app,
        R.drawable.ic_profile_app,
    )
}

/*
    * get Products in DataBase
    * example: var mutableList: MutableList<List<Quadruple<String, String, String, Int>>> = mutableListOf()
*/
object AppListProducts {
    val listProducts: List<Quadruple> = listOf(
        Quadruple("Nike Acer", "$160", "4.5", R.drawable.ic_tenis_09),
        Quadruple("Adidas UltraBoost", "$180", "4.8", R.drawable.ic_tenis_02),
        Quadruple("Puma RS-X", "$120", "4.2", R.drawable.ic_tenis_03),
        Quadruple("Reebok Classic", "$90", "4.0", R.drawable.ic_tenis_04),
        Quadruple("New Balance 990", "$200", "4.7", R.drawable.ic_tenis_05),
        Quadruple("Asics Gel-Kayano", "$160", "4.6", R.drawable.ic_tenis_06),
        Quadruple("Under Armour HOVR", "$150", "4.4", R.drawable.ic_tenis_07),
        Quadruple("Saucony Kinvara", "$130", "4.3", R.drawable.ic_tenis_08)
    )
}

@Composable
fun BottomNavigationBar() {
    val listScreen = AppImages.imagesBottomNavigation

    NavigationBar(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            ),
        containerColor = Color(0xFF282A2F)
    ) {
        listScreen.forEach { icon ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFFFFF),
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                ),
                selected = true,
                onClick = { /*TODO:*/ },
                icon = {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            )
        }
    }
}

@Composable
fun CarouselIndicator(qtdHeaders: Int, state: PagerState) {
    LazyRow(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(qtdHeaders) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .border(1.dp, color = Color.White, shape = CircleShape)
                    .background(
                        color = if (index == state.currentPage) Color.White else Color.Transparent,
                        shape = CircleShape
                    )
            )

            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeContent(padding: PaddingValues) {
    val listProducts = AppListProducts.listProducts

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.BackgroundAppColor)
            .padding(padding)
    ) {
        item {
            val qtdHeaders = 3
            val state = rememberPagerState(pageCount = { qtdHeaders })

            HorizontalPager(state = state, modifier = Modifier.fillMaxWidth()) { page ->
                when (page) {
                    0 -> DiscountCard()
                    1 -> NewArrivalsSection()
                    2 -> FeaturedWeek()
                }
            }

            CarouselIndicator(
                qtdHeaders = qtdHeaders,
                state = state
            )
        }

        item {
            FlowRow(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                maxItemsInEachRow = 2,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listProducts.forEach { (name, value, notice, img) ->
                    CardProduct(
                        name = name,
                        value = value,
                        notice = notice,
                        img = img,
                        modifier = Modifier,
                        onClick = {
                            val info = Quadruple(
                                name,
                                value,
                                notice,
                                img
                            )
                            val json = Gson().toJson(info)

                            navControllerGlobal!!.navigate(route = "product/$json")
                        }
                    )
                }
            }
        }

    }
}

@Composable
fun HomeApp(navController: NavController?) {
    navControllerGlobal = navController

    Scaffold(
        topBar = {
            TopBarApp()
        },
        content = { paddingValues ->
            HomeContent(
                padding = paddingValues
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    )
}


@Preview(showBackground = false,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=791,unit=dp,dpi=420"
)
@Composable
fun GetViewHomeApp() {
    ECommerceAppTheme {
        HomeApp(navController = null)
    }
}