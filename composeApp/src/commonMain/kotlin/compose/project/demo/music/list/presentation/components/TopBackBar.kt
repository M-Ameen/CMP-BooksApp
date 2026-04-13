package compose.project.demo.music.list.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import composedemo.composeapp.generated.resources.Res
import composedemo.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource


@Composable
fun TopBackBar(modifier: Modifier= Modifier, onBackClicked: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        // Left icon
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.clickable {
                    onBackClicked()
                }
            )
        }


    }
}


@Composable
@Preview
fun TopBackBarPreview() {
    TopBackBar(onBackClicked = {

    })
}

