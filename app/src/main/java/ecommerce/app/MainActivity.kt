package ecommerce.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ecommerce.app.ui.screen.HomeApp
import ecommerce.app.ui.screen.ProductPage
import ecommerce.app.ui.theme.ECommerceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeApp(navController = navController)
        }
        composable(route = "product/{info}") { backStackEntry ->
            ProductPage(
                navBackStackEntry = backStackEntry
            )
        }
    }
}