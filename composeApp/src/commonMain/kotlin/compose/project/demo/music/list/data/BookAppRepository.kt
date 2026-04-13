package compose.project.demo.music.list.data

import co.touchlab.kermit.Logger

class BookAppRepository(
    private val musicDao: BookDao,
    private val musicDataFetcher: BookDataFetcher
) {
    suspend fun fetchBook(): List<Book> {
        Logger.d("BookDataFetcherImpl") { "fetchBook repo" }
        return musicDataFetcher.fetchBook()
    }

    suspend fun insertBook(book: Book) {
        musicDao.insertBook(book)
    }

    suspend fun updateBook(book: Book) {
        musicDao.updateBook(book)
    }

    suspend fun deleteBook(book: Book) {
        musicDao.deleteBook(book)
    }

    suspend fun getBookById(id: Long): Book? {
        return musicDao.getBookById(id)
    }

    fun getBookList() = musicDao.getBookList()
}
