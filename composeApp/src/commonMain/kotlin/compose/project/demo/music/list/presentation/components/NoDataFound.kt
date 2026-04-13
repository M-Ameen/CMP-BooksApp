package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.demo.theme.Black
import composedemo.composeapp.generated.resources.Res
import composedemo.composeapp.generated.resources.no_data_found
import org.jetbrains.compose.resources.painterResource

@Composable
fun NoDataFound(onSyncClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No Books Found",
            fontSize = 19.sp,
            color = Black,
        )

        Image(
            painter = painterResource(Res.drawable.no_data_found),
            contentDescription = null,
            modifier = Modifier.size(200.dp).padding(vertical = 24.dp)
        )

        Text(
            text = "Tap to Sync Books",
            fontSize = 16.sp,
            color = Black,
            modifier = Modifier
                .clickable { onSyncClick() }
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun NoDataFoundPreview(){
    NoDataFound()
}