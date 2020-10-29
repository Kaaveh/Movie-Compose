package ir.kaaveh.moviecompose.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import ir.kaaveh.moviecompose.data.repository.MovieRepository
import ir.kaaveh.moviecompose.data.repository.database.MovieDatabase
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {


    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val dataSource = MovieDatabase.getInstance(applicationContext)
        return try {
            val repository = MovieRepository(dataSource)
            repository.refreshMovies("batman")
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}