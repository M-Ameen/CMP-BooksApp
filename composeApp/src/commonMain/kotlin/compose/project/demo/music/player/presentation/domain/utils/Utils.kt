package compose.project.demo.music.player.presentation.domain.utils

import compose.project.demo.music.list.data.Author
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.list.data.Formats

object Utils {

    fun getDummyBookModel(): Book{
        return Book(
            title = "title",
            authors = listOf(Author(
                birth_year = 50,
                death_year = 50,
                name = "Author Name"
            )),
            summaries = listOf("Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries Book Summaries"),
            formats = Formats(image = "https://resources.eventgroove.com.au/images/template/7474/33/books-poster__front.jpg")
        )
    }
     fun formatDuration(duration: Long): String {
        val minutes = duration / 1000 / 60
        val seconds = (duration / 1000) % 60
        return "${minutes}:${seconds.toString().padStart(2, '0')}"
    }

}