package compose.project.demo.music.list.data

import kotlinx.serialization.Serializable

@Serializable
data class BookResult(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Book> = emptyList()
)