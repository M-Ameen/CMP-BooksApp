package compose.project.demo.music.list.di


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import compose.project.demo.music.list.data.BookAppDatabase
import compose.project.demo.music.list.data.BookDataFetcher
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { getBookAppDatabase(getDatabaseBuilder(get())) }
}

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<BookAppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("book.db")
    return Room.databaseBuilder<BookAppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
