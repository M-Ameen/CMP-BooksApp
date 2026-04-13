package compose.project.demo.music.list.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import compose.project.demo.music.list.data.Book
import compose.project.demo.music.list.data.BookAppDatabase
import compose.project.demo.music.list.data.BookAppRepository
import compose.project.demo.music.list.data.BookDao
import compose.project.demo.music.list.presentation.BookAppViewModel

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import compose.project.demo.music.list.data.BookDataFetcher
import compose.project.demo.music.list.data.BookDataFetcherImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }
    single<BookDataFetcher> { BookDataFetcherImpl(get()) }
    single<BookDao> { get<BookAppDatabase>().bookDao() }
    single { BookAppRepository(get(), get()) }
    viewModel { BookAppViewModel(get()) }
}

expect fun platformModule(): Module

fun getBookAppDatabase(
    builder: RoomDatabase.Builder<BookAppDatabase>
): BookAppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
