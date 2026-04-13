package compose.project.demo.music.list.di

import androidx.room.Room
import compose.project.demo.music.list.data.MusicAppDatabase
import compose.project.demo.music.list.data.BookDataFetcher
import org.koin.dsl.module
import java.io.File

actual fun platformModule() = module {
    single<MusicAppDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "music.db")
        val builder = Room.databaseBuilder<MusicAppDatabase>(
            name = dbFile.absolutePath,
        )
        getMusicAppDatabase(builder)
    }
    single<BookDataFetcher> {
        object : BookDataFetcher {
            override suspend fun fetchBook(): List<Music> = emptyList()
        }
    }
    single<PermissionHandler> {
        object : PermissionHandler {
            override val requiredPermission: String = ""
            override fun hasMusicPermission(): Boolean = true
        }
    }
}
