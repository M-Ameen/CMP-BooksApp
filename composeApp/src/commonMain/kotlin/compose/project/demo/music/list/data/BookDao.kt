package compose.project.demo.music.list.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(music: Book)

    @Update
    suspend fun updateBook(music: Book)

    @Delete
    suspend fun deleteBook(music: Book)

    @Query("SELECT * FROM book")
    fun getBookList(): Flow<List<Book>>

    @Query("SELECT * FROM book WHERE id = :id")
    suspend fun getBookById(id: Long): Book?
}
