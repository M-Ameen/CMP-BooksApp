package compose.project.demo.music.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.list.data.BookAppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BookAppViewModel(
    private val repository: BookAppRepository,
) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSyncing = MutableStateFlow(false)
    val isSyncing = _isSyncing.asStateFlow()


    private val _allBook = MutableStateFlow<List<Book>>(emptyList())
    val allBook = _allBook.asStateFlow()

    val bookList = combine(_allBook, _searchText) { books, query ->
        if (query.isBlank()) books
        else books.filter { item ->
            item.title?.contains(query, ignoreCase = true) == true
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun onSearchTextChanged(query: String) {
        _searchText.value = query
    }

    fun syncBook() {
        viewModelScope.launch {
                performSync()
        }
    }

    private suspend fun performSync() {
        _isSyncing.value = true
        try {
            _allBook.value = repository.fetchBook()
        } catch (e: Exception) {
            // Handle error (e.g., log it or show a message)
        } finally {
            _isSyncing.value = false
        }
    }

    fun deleteTask(task: Book) {
        viewModelScope.launch {
            repository.deleteBook(task)
        }
    }
}
