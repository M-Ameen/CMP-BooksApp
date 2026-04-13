package compose.project.demo.todo.list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.project.demo.theme.Black
import compose.project.demo.theme.Text_Primary
import composedemo.composeapp.generated.resources.Res
import composedemo.composeapp.generated.resources.ic_add
import composedemo.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    label: String = "Label",
    value: String,
    onValueChanged: (String) -> Unit
) {

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            modifier = Modifier.weight(1f)
                .clip(RoundedCornerShape(50.dp)).border(
                    width = 2.dp, color = Text_Primary,
                    RoundedCornerShape(50.dp)
                ),
            value = value,
            placeholder = {
                Text(
                    text = "Search...",
                    color = Black.copy(alpha = 0.4f)
                )
            },
            maxLines = 1,
            onValueChange = { onValueChanged(it) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                // Cursor
                cursorColor = Black,

                // Selection (handles + highlight)
                selectionColors = TextSelectionColors(
                    handleColor = Black,
                    backgroundColor = Black.copy(alpha = 0.4f)
                ),

                // Indicator lines
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )


    }


}


@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(
        value = " ",
        onValueChanged = {

        }
    )
}


