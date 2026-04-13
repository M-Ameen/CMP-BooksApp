package compose.project.demo.music.list.data

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

import io.ktor.client.statement.bodyAsText

class BookDataFetcherImpl(
    private val client: HttpClient
) : BookDataFetcher {
    override suspend fun fetchBook(): List<Book> {
        Logger.d("BookDataFetcherImpl") { "fetchBook" }
        return try {
            val response = client.get("https://gutendex.com/books")
            val responseBody = response.body<BookResult>()
            Logger.d("BookDataFetcherImpl") { "Response status: ${responseBody}" }
            responseBody.results
        } catch (e: Exception) {
            Logger.e("BookDataFetcherImpl", e) {
                "Error fetching books: ${e.message}"
            }
            // Print to standard output as well, just in case
            println("BookDataFetcherImpl Error: $e")
            emptyList()
        }
    }
}
