package ir.kaaveh.moviecompose

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.kaaveh.moviecompose.data.model.Movie
import ir.kaaveh.moviecompose.ui.MovieComposeTheme
import ir.kaaveh.moviecompose.viewmodel.MovieViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieViewModel: MovieViewModel by viewModels()

        setContent {
            MovieComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieViewModel)
                }
            }
        }
    }
}

@Composable
fun MovieList(movieViewModel: MovieViewModel) {

    val movies by movieViewModel.movies.observeAsState()

    movies?.let {
        LazyColumnFor(it) { movie ->
            MovieItem(movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieComposeTheme {
        MovieItem()
    }
}

val batman = Movie(
    "Batman v Superman: Dawn of Justice",
    "2016",
    "tt2975590",
    "movie",
    "URL"
)