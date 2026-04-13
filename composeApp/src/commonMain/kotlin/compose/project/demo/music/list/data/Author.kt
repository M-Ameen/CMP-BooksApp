package compose.project.demo.music.list.data

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val birth_year: Int? = null,
    val death_year: Int? = null,
    val name: String? = null
)