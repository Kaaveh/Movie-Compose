package ir.kaaveh.moviecompose

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.coil.CoilImage
import ir.kaaveh.moviecompose.data.model.Movie

@Preview("Movie Item")
@Composable
fun MovieItem(
        movie: Movie = batman
) {
    Card(
            elevation = 4.dp,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
    ) {
        Row(
                modifier = Modifier
                        .clickable { /* todo */ }
                        .background(MaterialTheme.colors.surface)
                        .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            MoviePhoto(movie.poster)
            Column(
                    modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                        text = movie.title
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                        text = movie.year
                )
            }
        }
    }
}

@Composable
fun MoviePhoto(
        imageUrl: String
) {
    CoilImage(
            data = imageUrl,
            fadeIn = true,
            modifier = Modifier
                    .height(130.dp)
                    .clip(RoundedCornerShape(6.dp)),
            contentScale = ContentScale.FillHeight,
    )

}