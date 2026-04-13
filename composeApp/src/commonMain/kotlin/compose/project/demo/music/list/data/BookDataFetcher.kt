package compose.project.demo.music.list.data

interface BookDataFetcher {
    suspend fun fetchBook(): List<Book>
}
