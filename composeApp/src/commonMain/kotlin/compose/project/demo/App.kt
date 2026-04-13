package compose.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import compose.project.demo.music.list.presentation.BookListScreen
import compose.project.demo.theme.AppTheme
import compose.project.demo.theme.White

@Composable
@Preview
fun App() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = White).safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Navigator(BookListScreen())
        }
    }
}