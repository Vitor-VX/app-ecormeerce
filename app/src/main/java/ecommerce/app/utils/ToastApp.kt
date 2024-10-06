package ecommerce.app.utils

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

object ToastApp {
    @Composable
    fun showToast(text: String) {
        val context = LocalContext.current

        Toast.makeText(
            context,
            text,
            Toast.LENGTH_LONG
        ).show()
    }
}