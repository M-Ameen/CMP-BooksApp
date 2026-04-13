package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.demo.theme.Black
import compose.project.demo.theme.Text_Primary
import composedemo.composeapp.generated.resources.Res
import composedemo.composeapp.generated.resources.ic_book
import composedemo.composeapp.generated.resources.ic_music
import composedemo.composeapp.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource


@Composable
fun TopBarHome(modifier: Modifier= Modifier, isGridView: Boolean = false) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth(),
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Black,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Books")
            }
            withStyle(
                style = SpanStyle(
                    color = Text_Primary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(" App")
            }
        }
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.ic_book),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                colorFilter = ColorFilter.tint(color = Text_Primary)
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = annotatedString,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
            )
        }



    }

}


@Preview
@Composable
fun TopBarHomePreview() {
    TopBarHome()
}