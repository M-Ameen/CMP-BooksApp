package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.touchlab.kermit.Logger
import coil3.compose.AsyncImage
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.player.presentation.domain.utils.Utils.getDummyBookModel
import compose.project.demo.theme.GRAY
import compose.project.demo.theme.GRAYStroke


@Composable
fun BookItem(book: Book, onBookClicked: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, color = GRAYStroke, shape = RoundedCornerShape(20.dp))
            .background(color = GRAY)
            .clickable {
                onBookClicked()
            }.padding(16.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(120.dp).width(90.dp)
                .clip(RoundedCornerShape(12.dp)),
            model = book.formats?.image ?: "",
            contentDescription = null,
            placeholder = ColorPainter(Gray),
            error = ColorPainter(Gray),
            contentScale = ContentScale.Crop,
        )

        Column(modifier = Modifier.fillMaxWidth().padding(start = 12.dp)) {
            Text(
                modifier = Modifier,
                text = book.title ?: "Unknown Title",
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier,
                text = "Author: ${book.authors?.firstOrNull()?.name ?: "Unknown"}",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Gray
            )
            Text(
                modifier = Modifier,
                text = book.summaries?.get(0) ?: "Unknown Summary",
                fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}


@Preview
@Composable
fun BookItemPreview() {
    BookItem(
        book = getDummyBookModel(),
        onBookClicked = {

        }
    )
}