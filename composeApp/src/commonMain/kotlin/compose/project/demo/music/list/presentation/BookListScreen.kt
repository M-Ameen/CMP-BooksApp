package compose.project.demo.music.list.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.project.demo.music.list.presentation.components.BookCountBar
import compose.project.demo.music.list.presentation.components.BookItem
import compose.project.demo.music.list.presentation.components.NoDataFound
import compose.project.demo.music.list.presentation.components.TopBarHome
import compose.project.demo.music.player.presentation.BookDetailsScreen
import compose.project.demo.todo.list.presentation.components.SearchBar
import org.koin.compose.viewmodel.koinViewModel

class BookListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: BookAppViewModel = koinViewModel()
        val searchText by viewModel.searchText.collectAsState()
        val musicList by viewModel.bookList.collectAsState()
        val isSyncing by viewModel.isSyncing.collectAsState()


        LaunchedEffect(Unit) {
            viewModel.syncBook()
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBarHome(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(bottom = 12.dp)
            )

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 12.dp),
                onValueChanged = {
                    viewModel.onSearchTextChanged(it)
                },
                value = searchText
            )

            BookCountBar(
                Modifier
                    .padding(horizontal = 22.dp, vertical = 12.dp),
                "${musicList.size} books"
            )

            if (musicList.isEmpty()) {
                NoDataFound(onSyncClick = {
                    viewModel.syncBook()
                })
            } else {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 22.dp).padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(musicList) { music ->
                        BookItem(music, onBookClicked = {
                            navigator.push(BookDetailsScreen(music))
                        })
                    }
                }

            }

        }
    }
}


@Composable
@Preview
fun BookListScreenPreview() {
    BookListScreen().Content()
}


