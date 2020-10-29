package ir.kaaveh.moviecompose.data.repository.network

import ir.kaaveh.moviecompose.data.model.Movie
import ir.kaaveh.moviecompose.data.model.MoviesResponse
import retrofit2.Response
import java.io.IOException

class MovieNetworkDataSource {

    suspend fun fetchMovies(movieName: String): List<Movie>? {
        var response: Response<MoviesResponse>? = null
        var movies: List<Movie>? = null

        try {
            response = MyAPI().getMovies(movieName)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        response?.let {
            if (response.isSuccessful) {
                movies = response.body()?.movieList
            }
        }
        return movies
    }
}