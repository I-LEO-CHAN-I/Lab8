package database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.leonchik.android.lab8.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY priority ASC")
    suspend fun getTask(): MutableList<Task>

    @Insert
    suspend fun addTask(task: Task)

    @Delete
    suspend fun delTask(task: Task)

}