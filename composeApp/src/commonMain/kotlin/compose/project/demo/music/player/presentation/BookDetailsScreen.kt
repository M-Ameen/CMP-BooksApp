package compose.project.demo.music.player.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.list.presentation.components.TopBackBar
import compose.project.demo.music.player.presentation.components.BookDetailsSection
import compose.project.demo.music.player.presentation.domain.utils.Utils.getDummyBookModel


class BookDetailsScreen(
    private val book: Book,
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(modifier = Modifier.fillMaxSize()) {

            TopBackBar(
                modifier = Modifier.padding(horizontal = 22.dp),
            ) {
                navigator.pop()
            }


            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                BookDetailsSection(modifier = Modifier.padding(horizontal = 22.dp), book)
            }
        }
    }
}

@Preview
@Composable
fun BookDetailsScreenPreview() {
    BookDetailsScreen(
        book = getDummyBookModel(),
    ).Content()
}
