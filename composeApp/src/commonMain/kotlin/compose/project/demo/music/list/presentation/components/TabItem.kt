package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.demo.theme.LightPrimary
import compose.project.demo.theme.Text_Primary
import compose.project.demo.theme.White


@Composable
fun TabItem(
    tabName: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {

    val textColor = if (isSelected) White else Text_Primary
    val containerColor = if (isSelected) Text_Primary else LightPrimary
    Text(
        modifier = Modifier.clip(RoundedCornerShape(100.dp)).clickable{
            onSelected()
        }.background(containerColor).padding(vertical = 8.dp, horizontal = 24.dp),
        text = tabName,
        fontSize = 18.sp,
        color = textColor
    )
}

@Preview
@Composable
fun TabItemPreview() {
    TabItem(tabName = "Completed", isSelected = true, onSelected = {

    })
}