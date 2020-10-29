package ir.kaaveh.moviecompose.data.repository

import ir.kaaveh.moviecompose.data.repository.database.MovieDatabase
import ir.kaaveh.moviecompose.data.repository.network.MovieNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDatabase: MovieDatabase
) {
    val movies = movieDatabase.movieDatabaseDao.getAllMovies()

    suspend fun refreshMovies(movieName: String) {
        withContext(Dispatchers.IO) {
            val movies = async { MovieNetworkDataSource().fetchMovies(movieName) }
            movies.await()?.let { movieDatabase.movieDatabaseDao.insert(it) }
        }
    }
}