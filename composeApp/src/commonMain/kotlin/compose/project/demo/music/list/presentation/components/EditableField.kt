package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.demo.theme.Black
import compose.project.demo.theme.Text_Secondary
import compose.project.demo.theme.White

@Composable
fun EditableField(
    modifier: Modifier = Modifier,
    label: String = "Label",
    placeHolder: String = "PlaceHolder",
    value: String,
    onValueChanged: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = White)
            .padding(16.dp)
    ) {
        Text(
            text = label,
            fontSize = 11.sp,
            color = Text_Secondary
        )
        TextField(
            value = value,
            placeholder = {
                Text(
                    text = placeHolder,
                    color = Black.copy(alpha = 0.4f)
                )
            },
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

@Composable
@Preview
fun EditableFieldPreview() {
    EditableField(
        value = "",
        onValueChanged = { }
    )
}