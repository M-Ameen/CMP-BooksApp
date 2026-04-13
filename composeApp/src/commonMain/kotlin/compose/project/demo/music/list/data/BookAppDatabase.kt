package compose.project.demo.music.list.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

import androidx.room.TypeConverters

@Database(entities = [Book::class], version = 1)
@TypeConverters(ListConverter::class)
@ConstructedBy(BookAppDatabaseConstructor::class)
abstract class BookAppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}


@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookAppDatabaseConstructor : RoomDatabaseConstructor<BookAppDatabase> {
    override fun initialize(): BookAppDatabase
}