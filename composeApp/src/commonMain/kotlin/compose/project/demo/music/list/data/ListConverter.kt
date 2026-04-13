package compose.project.demo.music.list.data

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListConverter {

    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String {
        return json.encodeToString(list ?: emptyList())
    }

    @TypeConverter
    fun toIntList(data: String?): List<Int> {
        return if (data.isNullOrEmpty()) emptyList() else json.decodeFromString(data)
    }

    @TypeConverter
    fun fromStringList(list: List<String>?): String {
        return json.encodeToString(list ?: emptyList())
    }

    @TypeConverter
    fun toStringList(data: String?): List<String> {
        return if (data.isNullOrEmpty()) emptyList() else json.decodeFromString(data)
    }

    @TypeConverter
    fun fromAuthorList(list: List<Author>?): String {
        return json.encodeToString(list ?: emptyList())
    }

    @TypeConverter
    fun toAuthorList(data: String?): List<Author> {
        return if (data.isNullOrEmpty()) emptyList() else json.decodeFromString(data)
    }

    @TypeConverter
    fun fromFormats(formats: Formats?): String {
        return json.encodeToString(formats ?: Formats())
    }

    @TypeConverter
    fun toFormats(data: String?): Formats {
        return if (data.isNullOrEmpty()) Formats() else json.decodeFromString(data)
    }
}
