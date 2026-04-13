package compose.project.demo.music.list.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Formats(
    @SerialName("image/jpeg")
    val image: String? = null
)