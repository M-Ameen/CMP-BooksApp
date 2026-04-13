package compose.project.demo.music.list.di

import androidx.room.Room
import androidx.room.RoomDatabase
import compose.project.demo.music.list.data.BookAppDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun platformModule(): Module = module {
    single<BookAppDatabase> {
        val builder = getDatabaseBuilder()
        getBookAppDatabase(builder)
    }
}

fun getDatabaseBuilder(): RoomDatabase.Builder<BookAppDatabase> {
    val dbFilePath = documentDirectory() + "/book.db"
    return Room.databaseBuilder<BookAppDatabase>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}