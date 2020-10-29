package ir.kaaveh.moviecompose.data.model

import com.google.gson.annotations.SerializedName
import ir.kaaveh.moviecompose.data.model.Movie

data class MoviesResponse (
    @SerializedName("Search")
    val movieList: List<Movie>,
    val totalResults: String,
    val Response: String
)