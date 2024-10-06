package ecommerce.app.ui.utils.home

import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AnimateCarousel(
    state: PagerState,
    pageCount: Int,
    goNext: Boolean = false
) {
    val coroutineScope = rememberCoroutineScope()

    if (!goNext) {
        LaunchedEffect(Unit) {
            delay(3000)
            state.animateScrollToPage(1)
        }
    }

    LaunchedEffect(state.currentPage) {
        delay(3000)
        val nextPage = (state.currentPage + 1) % pageCount

        coroutineScope.launch {
            state.animateScrollToPage(nextPage)
        }
    }
}