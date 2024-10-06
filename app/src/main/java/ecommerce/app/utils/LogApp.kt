package ecommerce.app.utils

import android.util.Log

object LogApp {
    private const val TAG = "EcommerceApp"

    fun log(text: String) {
        Log.v(TAG, text)
    }
}