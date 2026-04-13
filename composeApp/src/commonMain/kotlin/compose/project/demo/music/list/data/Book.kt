package compose.project.demo.music.list.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "book")
@Serializable
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val authors: List<Author>? = emptyList(),
    val summaries: List<String>? = emptyList(),
    val subjects: List<String>? = emptyList(),
    val copyright: Boolean? = null,
    val download_count: Int? = null,
    val formats: Formats? = null,
    val languages: List<String>? = emptyList(),
    val media_type: String? = null
)