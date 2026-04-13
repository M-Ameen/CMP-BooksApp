package compose.project.demo.music.player.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.player.presentation.domain.utils.Utils.getDummyBookModel

@Composable
fun BookDetailsSection(
    modifier: Modifier = Modifier, book: Book
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        AsyncImage(
            model = book.formats?.image,
            modifier = Modifier.height(330.dp)
                .width(237.dp)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape((20.dp))),
            contentDescription = "Book Image",
            placeholder = ColorPainter(Gray),
            error = ColorPainter(Gray),
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = book.title ?: "Unknown Title",
            fontSize = 32.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Author: ${book.authors?.firstOrNull()?.name ?: "Unknown"}",
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Gray
        )
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = book.summaries?.get(0) ?: "Unknown Summary",
            fontSize = 20.sp,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
@Preview
fun BookDetailsSectionPreview() {
    BookDetailsSection(book = getDummyBookModel())
}



