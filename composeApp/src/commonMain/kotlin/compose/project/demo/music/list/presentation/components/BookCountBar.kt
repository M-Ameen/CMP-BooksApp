package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun BookCountBar(modifier: Modifier = Modifier, totalMusicListSize: String) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier,
            text = totalMusicListSize,
            fontSize = 25.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
        /* Row {
             Text(
                 modifier = Modifier,
                 text = "Ascending",
                 fontSize = 25.sp,
                 maxLines = 1,
                 overflow = TextOverflow.Ellipsis,
                 textAlign = TextAlign.Center,
             )
         }*/
    }
}

@Preview
@Composable
fun BookCountBarPreview() {
    BookCountBar(totalMusicListSize = "5000")
}